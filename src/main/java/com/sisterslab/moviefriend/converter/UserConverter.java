package com.sisterslab.moviefriend.converter;

import com.sisterslab.moviefriend.dto.request.UserRequest;
import com.sisterslab.moviefriend.dto.response.UserResponse;
import com.sisterslab.moviefriend.model.User;
import lombok.experimental.UtilityClass;
import java.util.stream.Collectors;

@UtilityClass
public class UserConverter {

    public User convertToUser(UserRequest userRequest){
        User user=new User();
        user.setUserName(userRequest.getUserName());
        user.setName(userRequest.getName());
        user.setSurName(userRequest.getSurName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    public UserResponse convertToUserResponse(User user){
        UserResponse userResponse=new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUserName(user.getUserName());
        userResponse.setSurName(user.getSurName());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        if(!user.getFilms().isEmpty()){
            userResponse.setFilms(user.getFilms()
                    .stream()
                    .map(FilmConverter::convertToFilmResponse)
                    .collect(Collectors.toList()));
        }
        return userResponse;
    }
}
