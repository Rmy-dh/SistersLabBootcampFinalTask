package com.sisterslab.moviefriend.converter;

import com.sisterslab.moviefriend.dto.request.FilmCommentRequest;
import com.sisterslab.moviefriend.dto.response.FilmCommentResponse;
import com.sisterslab.moviefriend.model.FilmComment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FilmCommentConverter {
    public FilmComment convertToFilmComment(FilmCommentRequest filmCommentRequest){
        FilmComment filmComment=new FilmComment();
        filmComment.setComment(filmCommentRequest.getComment());
        filmComment.setMovieScore(filmCommentRequest.getMovieScore());
        filmComment.setFilm(filmCommentRequest.getFilm());
        filmComment.setUser(filmCommentRequest.getUser());

        return filmComment;
    }
    public FilmCommentResponse convertToFilmResponse(FilmComment filmComment){
        FilmCommentResponse filmCommentResponse=new FilmCommentResponse();
        filmCommentResponse.setComment(filmComment.getComment());
        filmCommentResponse.setMovieScore(filmComment.getMovieScore());
        filmCommentResponse.setFilmName(filmComment.getFilm().getName());
        filmCommentResponse.setUserName(filmComment.getUser().getUserName());

        return filmCommentResponse;
    }
}
