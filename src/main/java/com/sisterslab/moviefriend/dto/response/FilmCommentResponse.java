package com.sisterslab.moviefriend.dto.response;

import lombok.Data;

@Data
public class FilmCommentResponse {
    private String comment;
    private int movieScore;
    private String filmName;
    private String userName;

}
