package com.sisterslab.moviefriend.model;

import com.sisterslab.moviefriend.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user-comment")
public class FilmComment extends BaseModel {
    @Column(nullable = false)
    private String comment;
    private int movieScore;

    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
