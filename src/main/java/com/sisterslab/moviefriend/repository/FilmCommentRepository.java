package com.sisterslab.moviefriend.repository;

import com.sisterslab.moviefriend.model.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCommentRepository extends JpaRepository<FilmComment,Long> {
    FilmComment findFilmCommentByFilm_IdAndUser_Id(Long filmId,Long userId);
}
