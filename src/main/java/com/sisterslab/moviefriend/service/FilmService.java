package com.sisterslab.moviefriend.service;

import com.sisterslab.moviefriend.dto.request.FilmRequest;
import com.sisterslab.moviefriend.dto.response.FilmResponse;

import java.util.List;

public interface FilmService {
     FilmResponse saveFilm(FilmRequest filmRequest);
     FilmResponse getFilmByName(String filmName);
     List<FilmResponse> getAllFilms();
     String updateFilmName(String name,FilmRequest filmRequest);
     String updateFilmExplanation(String name, FilmRequest filmRequest);
     String updateFilmScoreByName(String name, FilmRequest filmRequest);
     void deleteFilmByName(String name);
     FilmResponse addUseToFilmList(Long filmId, Long userId);
    List<FilmResponse> getFilmIfScoreGreaterThan(int score);
}
