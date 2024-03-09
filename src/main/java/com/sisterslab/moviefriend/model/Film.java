package com.sisterslab.moviefriend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sisterslab.moviefriend.core.model.BaseModel;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "film-information")
public class Film extends BaseModel {
    private String name;
    private String  explanation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private int score;
    private String mark= MovieFriendConstant.O.getName();               //o-> open (not watched) c-> closed (watched)
    private String category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "watch-list",
            joinColumns = @JoinColumn(name = "film-id"),
            inverseJoinColumns = @JoinColumn(name = "user-id")
    )
    private List<User> users=new ArrayList<>();
    public  void addUserToUserList(User user){
        users.add(user);
    }
    public void deleteUserFromUserList(User user){
        users.remove(user);
    }
}



