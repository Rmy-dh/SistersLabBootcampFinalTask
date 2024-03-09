package com.sisterslab.moviefriend.service.impl;

import com.sisterslab.moviefriend.converter.UserConverter;
import com.sisterslab.moviefriend.dto.request.UserRequest;
import com.sisterslab.moviefriend.dto.response.UserResponse;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import com.sisterslab.moviefriend.model.Film;
import com.sisterslab.moviefriend.model.User;
import com.sisterslab.moviefriend.repository.IFilmRepository;
import com.sisterslab.moviefriend.repository.IUserRepository;
import com.sisterslab.moviefriend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private final IUserRepository userRepository;
    private final IFilmRepository filmRepository;
    private final FilmUserService filmUserService;
    public UserResponse saveUser(UserRequest userRequest) {
        try{
            if (Objects.isNull(userRepository.findByNameAndSurName(userRequest.getName(), userRequest.getSurName()))) {
                return UserConverter.convertToUserResponse(userRepository.save(UserConverter.convertToUser(userRequest)));
            }
        }catch(Exception e){
            LOGGER.error(MovieFriendConstant.USERNAMNOTCORRECT.getName()+MovieFriendConstant.ARROW.getName()+ userRequest.getUserName());
        }
        LOGGER.info(userRequest.getName()+MovieFriendConstant.QUOTES.getName()+userRequest.getSurName()
                +MovieFriendConstant.ALREADYEXIST.getName());
        return null;
    }
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserConverter::convertToUserResponse)
                .collect(Collectors.toList());
    }
    public UserResponse changeUserPassword(String name, String surName, String password) {
        User user = userRepository.findByNameAndSurName(name, surName);
        if (Objects.nonNull(user) && !password.isEmpty()) {
            user.setPassword(password);
            userRepository.save(user);
            return UserConverter.convertToUserResponse(user);
        }
        LOGGER.info(name + MovieFriendConstant.QUOTES.getName()+ surName+ MovieFriendConstant.NOTFOUND.getName());
        return null;
    }
    public void deleteUserByNameAndSurname(String name, String surName) {
        User user = userRepository.findByNameAndSurName(name, surName);
        if (Objects.nonNull(user)) {
            userRepository.deleteById(user.getId());
            LOGGER.info(name + MovieFriendConstant.QUOTES.getName() + surName+MovieFriendConstant.DELETED.getName());
        }
        LOGGER.info(name+MovieFriendConstant.QUOTES.getName()+surName+MovieFriendConstant.NOTFOUND.getName());
    }
    public UserResponse getUserByName(String name) {
        User user = userRepository.findByName(name);
        return Objects.nonNull(user) ? UserConverter.convertToUserResponse(user) : null;
    }
    public UserResponse addFilmToFilmList(Long userId, Long filmId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Film> film = filmRepository.findById(filmId);
        if ((user.isPresent() && film.isPresent()) && ! filmUserService.isFilmExistInFilmList(film.get(),user.get())) {
            user.get().addFilmToFilmList(film.get());
            filmUserService.updateUserId(userId, filmId);
            LOGGER.info(film.get().getName() +MovieFriendConstant.ADDED.getName());
            return UserConverter.convertToUserResponse(userRepository.save(user.get()));
        }
        LOGGER.info(MovieFriendConstant.GIVENINFORMATIONNOTMATCHED.getName());
        return null;
    }
    @Override
    public void deleteFilmFromFilmList(Long userId, Long filmId) {
        Optional<Film> film=filmRepository.findById(filmId);
        Optional<User> user=userRepository.findById(userId);
        if(film.isPresent() && user.isPresent()){
            if(filmUserService.isFilmExistInFilmList(film.get(),user.get())){
                user.get().deleteFilmToFilmList(film.get());
                filmUserService.updateFilmIdForDeleteProcess(filmId,userId);
                userRepository.save(user.get());
                LOGGER.info(film.get().getName()+MovieFriendConstant.DELETED.getName());
            }
            LOGGER.info(film.get().getName()+MovieFriendConstant.NOTFOUND.getName());
        }
        LOGGER.error(MovieFriendConstant.GIVENINFORMATIONNOTMATCHED.getName());
    }
    @Override
    public void markTheFilm(Long userId, Long filmId) {
        Optional<Film> film=filmRepository.findById(filmId);
        Optional<User> user=userRepository.findById(userId);
        if (( film.isPresent() && user.isPresent()) && filmUserService.isFilmExistInFilmList(film.get(),user.get())){
            film.get().setMark(MovieFriendConstant.C.getName());
            filmRepository.save(film.get());
            user.get().markFilm(film.get());
            userRepository.save(user.get());
            LOGGER.info(film.get().getName()+MovieFriendConstant.UPDATED.getName());
        }
    }
}