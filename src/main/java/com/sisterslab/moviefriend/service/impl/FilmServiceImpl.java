package com.sisterslab.moviefriend.service.impl;

import com.sisterslab.moviefriend.converter.FilmConverter;
import com.sisterslab.moviefriend.dto.request.FilmRequest;
import com.sisterslab.moviefriend.dto.response.FilmResponse;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import com.sisterslab.moviefriend.model.Film;
import com.sisterslab.moviefriend.model.User;
import com.sisterslab.moviefriend.repository.IFilmRepository;
import com.sisterslab.moviefriend.repository.IUserRepository;
import com.sisterslab.moviefriend.service.FilmService;
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
public  class FilmServiceImpl implements FilmService {
    private static final Logger LOGGER= LogManager.getLogger(FilmServiceImpl.class);
    private final IFilmRepository filmRepository;
    private final IUserRepository userRepository;
    private final FilmUserService filmUserService;
    public FilmResponse saveFilm(FilmRequest filmRequest) {
        if(Objects.isNull(filmRepository.findByName(filmRequest.getName()))){
            return FilmConverter.convertToFilmResponse(filmRepository.save(FilmConverter.convertToFilm(filmRequest)));
        }
        LOGGER.info(filmRequest.getName()+MovieFriendConstant.ALREADYEXIST.getName());
        return null;
    }
    public FilmResponse getFilmByName(String filmName) {
        Film film= filmRepository.findByName(filmName);
        if(Objects.nonNull(film)){
            return FilmConverter.convertToFilmResponse(film);
        }else{
            LOGGER.info(filmName+MovieFriendConstant.NOTFOUND.getName());
            return null;
        }
    }
    public List<FilmResponse> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(FilmConverter::convertToFilmResponse)
                .collect(Collectors.toList());
    }
    public String updateFilmName(String name,FilmRequest filmRequest) {
        return setValue(name,filmRequest) ?MovieFriendConstant.NAMEUPDATED.getName()
                : MovieFriendConstant.GIVENINFORMATIONNOTMATCHED.getName();
    }
    public String updateFilmExplanation(String name, FilmRequest filmRequest) {
        return setValue(name,filmRequest) ? MovieFriendConstant.EXPLANATIONUPDATED.getName()
                :MovieFriendConstant.GIVENINFORMATIONNOTMATCHED.getName();
    }
    public String updateFilmScoreByName(String name, FilmRequest filmRequest) {
        return setValue(name,filmRequest)?  MovieFriendConstant.SCOREUPDATED.getName()
                : MovieFriendConstant.GIVENINFORMATIONNOTMATCHED.getName();
    }
    public void deleteFilmByName(String name) {
        if(Objects.nonNull(filmRepository.findByName(name)) ){
            filmRepository.deleteById(filmRepository.findByName(name).getId());
            LOGGER.info(name+MovieFriendConstant.DELETED.getName());
        }
    }
    public FilmResponse addUseToFilmList(Long filmId, Long userId) {
        Optional<Film> film=filmRepository.findById(filmId);
        Optional<User> user=userRepository.findById(userId);
        if((film.isPresent() && user.isPresent()) && ! filmUserService.isUserExistInUserList(film.get(),user.get())){
            film.get().addUserToUserList(user.get());
            filmRepository.save(film.get());
            filmUserService.updateFilmId(filmId,userId);
            return FilmConverter.convertToFilmResponse(filmRepository.save(film.get()));
        }
        return  null;
    }
    @Override
    public List<FilmResponse> getFilmIfScoreGreaterThan(int score) {

        return filmRepository.findAll()
                .stream()
                .filter(i->i.getScore()>score)
                .map(FilmConverter::convertToFilmResponse)
                .collect(Collectors.toList());
    }
    private boolean setValue(String name,FilmRequest filmRequest){
        Film film=filmRepository.findByName(name);
        if(Objects.nonNull(film) && Objects.nonNull(filmRequest)){
            if(filmRequest.getScore() !=0){
                film.setScore(filmRequest.getScore());
                filmRepository.save(film);
                return  true;
            }
            if(Objects.nonNull(filmRequest.getExplanation())){
                film.setExplanation(filmRequest.getExplanation());
                filmRepository.save(film);
                return true;
            }
            if(Objects.nonNull(filmRequest.getName())){
                film.setName(filmRequest.getName());
                filmRepository.save(film);
                return true;
            }
        }
        return false;
    }
}
