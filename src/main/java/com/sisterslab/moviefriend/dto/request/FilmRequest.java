package com.sisterslab.moviefriend.dto.request;

import lombok.Data;
import java.util.Date;

@Data
public class FilmRequest {
    private String name;
    private String  explanation;
    private Date releaseDate;
    private int score;
    private String category;

}
