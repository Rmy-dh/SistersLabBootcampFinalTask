package com.sisterslab.moviefriend.dto.response;

import com.sisterslab.moviefriend.model.User;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FilmResponse {
    private String name;
    private String  explanation;
    private Date releaseDate;
    private int score;
    private String category;
    private List<User> users=new ArrayList<>();
}
