package com.sisterslab.moviefriend.repository;

import com.sisterslab.moviefriend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
    Film findByName(String name);
}
