package com.sisterslab.moviefriend.controller;

import com.sisterslab.moviefriend.dto.request.FilmRequest;
import com.sisterslab.moviefriend.dto.response.FilmResponse;
import com.sisterslab.moviefriend.service.impl.FilmServiceImpl;
import com.sisterslab.moviefriend.shared.endpoints.FilmEndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(FilmEndPoints.FILM)
@RequiredArgsConstructor
public class FilmController {
   private final FilmServiceImpl filmService;

    @PostMapping
    public FilmResponse saveFilm(@RequestBody FilmRequest filmRequest){
        return  filmService.saveFilm(filmRequest);
    }
    @GetMapping("/{filmName}")
    public FilmResponse getFilmByName(@PathVariable String filmName){
        return filmService.getFilmByName(filmName);
    }
    @GetMapping
    public List<FilmResponse> getAllFilms(){
        return filmService.getAllFilms();
    }
    @PutMapping("/{name}")
    public String updateFilmNameOrExplanation(@PathVariable String name,@RequestBody FilmRequest filmRequest){

        return Objects.nonNull(filmRequest.getExplanation()) ?
                filmService.updateFilmExplanation(name,filmRequest)
                :filmService.updateFilmName(name,filmRequest);

    }
    @PutMapping("/film/{name}")
    public String updateFilmScore(@PathVariable String name,@RequestBody FilmRequest filmRequest){
        return filmService.updateFilmScoreByName(name,filmRequest);
    }
    @DeleteMapping("/{name}")
    public  void deleteFilmByName(@PathVariable String name){
        filmService.deleteFilmByName(name);
    }

    @PutMapping("/film/{filmId}/{userId}")
    public FilmResponse addUserToFilmList(@PathVariable Long filmId,@PathVariable Long userId ){
        return filmService.addUseToFilmList(filmId,userId);
    }
    @GetMapping("/score/{score}")
    public List<FilmResponse> getFilmIfScoreGreaterThan(@PathVariable int score){
        return filmService.getFilmIfScoreGreaterThan(score);
    }
    @GetMapping("/category/{category}")
    public List<FilmResponse>  getFilmByCategory(@PathVariable String category){
        return filmService.getFilmByCategory(category);
    }
}
