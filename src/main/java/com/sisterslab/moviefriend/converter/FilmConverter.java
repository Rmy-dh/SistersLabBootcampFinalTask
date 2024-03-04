package com.sisterslab.moviefriend.converter;

import com.sisterslab.moviefriend.dto.request.FilmRequest;
import com.sisterslab.moviefriend.dto.response.FilmResponse;
import com.sisterslab.moviefriend.model.Film;
import lombok.experimental.UtilityClass;

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
        FilmResponse filmResponse=new FilmResponse();
        filmResponse.setName(film.getName());
        filmResponse.setExplanation(film.getExplanation());
        filmResponse.setScore(film.getScore());
        filmResponse.setReleaseDate(film.getReleaseDate());
        filmResponse.setCategory(film.getCategory());
        return  filmResponse;
    }
}
