package com.sisterslab.moviefriend.dto.request;

import com.sisterslab.moviefriend.model.Film;
import com.sisterslab.moviefriend.model.User;
import lombok.Data;

@Data
public class FilmCommentRequest {
    private String comment;
    private int movieScore;
    private Film film;
    private User user;

}
