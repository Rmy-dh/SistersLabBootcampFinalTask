package com.sisterslab.moviefriend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sisterslab.moviefriend.core.model.BaseModel;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user-information")
@Getter
@Setter
public class User extends BaseModel {
    private static final Logger LOGGER= LogManager.getLogger(User.class);

    private String name;
    private String surName;

    @Column(nullable = false,unique = true)
    private String userName;

    private String email;

    @Column(length = 8)
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private List<Film> films=new ArrayList<>();

    public void addFilmToFilmList(Film film){
        films.add(film);
    }

    public void deleteFilmToFilmList(Film film){
        films.remove(film);
    }
    public void markFilm(Film film){
        films.get(films.indexOf(film)).setMark(MovieFriendConstant.C.getName());

    }
}
