package com.sisterslab.moviefriend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sisterslab.moviefriend.core.model.BaseModel;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user-information")
@Getter
@Setter
public class User extends BaseModel {

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

    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<FilmComment> filmComments;

    public void addFilmToFilmList(Film film){
        films.add(film);
    }

    public void deleteFilmToFilmList(Film film){
        films.remove(film);
    }
    public void markFilm(Film film){
        films.get(films.indexOf(film)).setMark(MovieFriendConstant.C.getName());

    }
    public void addFilmCommentToUserTable(FilmComment filmComment){
        this.filmComments.add(filmComment);
    }
}
