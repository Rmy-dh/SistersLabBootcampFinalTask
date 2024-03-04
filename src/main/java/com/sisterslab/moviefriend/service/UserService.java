package com.sisterslab.moviefriend.service;

import com.sisterslab.moviefriend.dto.request.UserRequest;
import com.sisterslab.moviefriend.dto.response.UserResponse;

import java.util.List;

public interface UserService {
     UserResponse saveUser(UserRequest userRequest);
     List<UserResponse> getAllUsers();
     UserResponse changeUserPassword(String name, String surName,String password);
     void deleteUserByNameAndSurname(String name, String surName);
     UserResponse getUserByName(String name);
     UserResponse addFilmToFilmList(Long userId, Long filmId);
     void deleteFilmFromFilmList(Long userId, Long filmId);

    void markTheFilm(Long userId, Long filmId);
}
