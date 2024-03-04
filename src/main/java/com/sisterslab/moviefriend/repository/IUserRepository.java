package com.sisterslab.moviefriend.repository;

import com.sisterslab.moviefriend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByNameAndSurName(String name,String surName);
    User findByName(String name);
}
