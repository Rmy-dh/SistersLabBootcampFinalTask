package com.sisterslab.moviefriend.controller;

import com.sisterslab.moviefriend.dto.request.UserRequest;
import com.sisterslab.moviefriend.dto.response.UserResponse;
import com.sisterslab.moviefriend.service.impl.UserServiceImpl;
import com.sisterslab.moviefriend.shared.endpoints.UserEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserEndPoints.USER)
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;


    @PostMapping
    public UserResponse saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }
    @GetMapping
    public List<UserResponse> getAllUser(){
        return userService.getAllUsers();
    }
    @PutMapping("/{name}/{surName}")
    public UserResponse changeUserPassword(@RequestParam String password,@PathVariable String name,@PathVariable String surName){
        return userService.changeUserPassword(name,surName,password);
    }
    @DeleteMapping("/{name}/{surName}")
    public void  deleteUserByNameAndSurname(@PathVariable String name,@PathVariable String surName){
        userService.deleteUserByNameAndSurname(name,surName);
    }
    @GetMapping("/{name}")
    public UserResponse getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }
    @PutMapping("/user/{userId}/{filmId}")
    public UserResponse addFilmToFilmList(@PathVariable Long userId,@PathVariable Long filmId){
        return userService.addFilmToFilmList(userId,filmId);
    }
    @PutMapping("/user/{userId}/film/{filmId}")
    public void deleteFilmFromFilmList(@PathVariable Long userId,@PathVariable Long filmId){
        userService.deleteFilmFromFilmList(userId,filmId);
    }
    @PutMapping
    public void markTheFilm(@RequestParam Long userId,@RequestParam Long filmId){
        userService.markTheFilm(userId,filmId);

    }

}
