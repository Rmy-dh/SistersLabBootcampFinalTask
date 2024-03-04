package com.sisterslab.moviefriend.dto.response;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {
    private String name;
    private String surName;
    private String userName;
    private String email;
    private String password;
    private List<FilmResponse> films=new ArrayList<>();
}
