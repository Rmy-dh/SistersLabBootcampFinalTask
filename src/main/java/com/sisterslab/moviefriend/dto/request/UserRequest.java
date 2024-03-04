package com.sisterslab.moviefriend.dto.request;


import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String surName;
    private String userName;
    private String email;
    private String password;
}
