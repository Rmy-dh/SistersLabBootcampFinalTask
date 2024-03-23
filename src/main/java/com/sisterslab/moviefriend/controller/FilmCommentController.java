package com.sisterslab.moviefriend.controller;

import com.sisterslab.moviefriend.dto.request.FilmCommentRequest;
import com.sisterslab.moviefriend.dto.response.FilmCommentResponse;
import com.sisterslab.moviefriend.service.FilmCommentService;
import com.sisterslab.moviefriend.shared.endpoints.FilmCommentEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FilmCommentEndPoints.FILMCOMMENT)
@RequiredArgsConstructor
public class FilmCommentController {
    private final FilmCommentService filmCommentService;

    @PostMapping("/{filmId}/{userId}")
    public FilmCommentResponse saveFilmComment(@PathVariable Long filmId, @PathVariable Long userId, @RequestBody FilmCommentRequest filmCommentRequest){
     return filmCommentService.saveComment(filmId,userId,filmCommentRequest);
    }
    @PutMapping("/{filmId}/{userId}")
    public FilmCommentResponse updateFilmComment(@PathVariable Long filmId,@PathVariable Long userId,@RequestBody FilmCommentRequest filmCommentRequest){
        return filmCommentService.updateFilmComment(filmId,userId,filmCommentRequest);
    }
    @PutMapping("/movieScore/{filmId}/{userId}")
    public String updateMovieScore(@PathVariable Long filmId,@PathVariable Long userId,@RequestBody FilmCommentRequest filmCommentRequest){
        return filmCommentService.updateMovieScore(filmId,userId,filmCommentRequest);
    }
    @DeleteMapping("/{filmId}/{userId}")
    public String deleteFilmComment(@PathVariable Long filmId,@PathVariable Long userId){
        return filmCommentService.deleteFilmComment(filmId,userId);
    }
}
