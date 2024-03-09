package com.sisterslab.moviefriend.converter;

import com.sisterslab.moviefriend.dto.request.FilmRequest;
import com.sisterslab.moviefriend.dto.response.FilmResponse;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import com.sisterslab.moviefriend.model.Film;
import lombok.experimental.UtilityClass;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@UtilityClass
public class FilmConverter {
    public Film convertToFilm(FilmRequest request){

        Film film=new Film();
        film.setName(request.getName());
        film.setExplanation(request.getExplanation());
        film.setScore(request.getScore());
        film.setReleaseDate(request.getReleaseDate());
        film.setCategory(request.getCategory());
        return film;
    }
    public FilmResponse convertToFilmResponse(Film film){
        FilmResponse filmResponse= convertToFilmResponseForUserTable(film);
        if(!film.getUsers().isEmpty()){
            filmResponse.setUsers(film.getUsers()
                    .stream()
                    .map(UserConverter::convertToUserResponse)
                    .collect(Collectors.toList()));
        }
        return  filmResponse;
    }
    public FilmResponse convertToFilmResponseForUserTable(Film film){
        SimpleDateFormat sdf=new SimpleDateFormat(MovieFriendConstant.YYYYMMDD.getName());
        FilmResponse filmResponse=new FilmResponse();
        filmResponse.setName(film.getName());
        filmResponse.setExplanation(film.getExplanation());
        filmResponse.setScore(film.getScore());
        filmResponse.setReleaseDate(sdf.format(film.getReleaseDate()));
        filmResponse.setCategory(film.getCategory());
        return  filmResponse;
    }
}
