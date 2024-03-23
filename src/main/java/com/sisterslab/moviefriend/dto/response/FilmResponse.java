package com.sisterslab.moviefriend.dto.response;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmResponse {
    private String name;
    private String  explanation;
    private String releaseDate;
    private int score;
    private String category;
    private List<UserResponse> users=new ArrayList<>();
    private List<FilmCommentResponse> filmCommentResponses=new ArrayList<>();
}
