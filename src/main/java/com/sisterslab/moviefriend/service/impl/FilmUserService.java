package com.sisterslab.moviefriend.service.impl;

import com.sisterslab.moviefriend.model.Film;
import com.sisterslab.moviefriend.model.User;
import com.sisterslab.moviefriend.repository.IFilmRepository;
import com.sisterslab.moviefriend.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmUserService {

     private  final IFilmRepository filmRepository;

     private  final IUserRepository userRepository;

    //USER TABLE -> film added to films -> update FILM TABLE users
    public void updateUserId(Long userId, Long filmId) {
        User realUser=userRepository.findById(userId).orElse(null);
        Film film=filmRepository.findById(filmId).orElse(null);
        film.addUserToUserList(realUser);
    }
    //FILM TABLE -> user added to users -> update USER TABLE films
    public void updateFilmId(Long filmId, Long userId) {
        User user=userRepository.findById(userId).orElse(null);
        Film film=filmRepository.findById(filmId).orElse(null);
        user.addFilmToFilmList(film);
    }
    //USER TABLE -> delete movie from films -> update FILM TABLE
    public void updateFilmIdForDeleteProcess(Long filmId,Long userId){
        User user=userRepository.findById(userId).orElse(null);
        Film film=filmRepository.findById(filmId).orElse(null);
        film.deleteUserFromUserList(user);
    }

    //USER TABLE -> film exist in films
    public boolean isFilmExistInFilmList(Film film, User user) {
        return user.getFilms().stream().anyMatch(i -> Objects.equals(i.getId(), film.getId()));
    }
    //FILM TABLE -> user exist in users
    public  boolean isUserExistInUserList(Film film,User user){
        return film.getUsers().stream().anyMatch(i-> Objects.equals(i.getId(), user.getId()));

    }
}
