package com.sisterslab.moviefriend.service;

import com.sisterslab.moviefriend.converter.FilmCommentConverter;
import com.sisterslab.moviefriend.dto.request.FilmCommentRequest;
import com.sisterslab.moviefriend.dto.response.FilmCommentResponse;
import com.sisterslab.moviefriend.filmMovieConstants.MovieFriendConstant;
import com.sisterslab.moviefriend.model.Film;
import com.sisterslab.moviefriend.model.FilmComment;
import com.sisterslab.moviefriend.model.User;
import com.sisterslab.moviefriend.repository.FilmCommentRepository;
import com.sisterslab.moviefriend.repository.FilmRepository;
import com.sisterslab.moviefriend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class FilmCommentService {
    private static final Logger LOGGER= LogManager.getLogger(FilmCommentService.class);
    private final FilmCommentRepository filmCommentRepository;
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;

    public FilmCommentResponse saveComment(Long filmId, Long userId, FilmCommentRequest filmCommentRequest) {
        Optional<Film> film=filmRepository.findById(filmId);
        Optional<User> user=userRepository.findById(userId);

        if(((film.isPresent() && user.isPresent()) && Objects.nonNull(filmCommentRequest ))
                && ( !isExist(filmId,userId))  && filmCommentRequest.getComment() !=null){
            filmCommentRequest.setFilm(film.get());
            filmCommentRequest.setUser(user.get());
            film.get().addFilmCommentsToFilmTable(FilmCommentConverter.convertToFilmComment(filmCommentRequest));
            user.get().addFilmCommentToUserTable(FilmCommentConverter.convertToFilmComment(filmCommentRequest));
            return FilmCommentConverter.convertToFilmResponse(
                    filmCommentRepository.save(FilmCommentConverter.convertToFilmComment(filmCommentRequest)));
        }
        return null;
    }
    public FilmCommentResponse updateFilmComment(Long filmId, Long userId, FilmCommentRequest filmCommentRequest) {
        if(isExist(filmId,userId)){
            for(FilmComment filmComment:filmCommentRepository.findAll()){
                if(filmComment.getFilm().getId().equals(filmId )&& filmComment.getUser().getId().equals(userId)){
                    filmComment.setComment(filmCommentRequest.getComment());
                    LOGGER.info(filmComment.getComment()+MovieFriendConstant.UPDATED.getName()+filmCommentRequest.getComment());
                    return FilmCommentConverter.convertToFilmResponse(filmCommentRepository.save(filmComment));
                }
            }
        }
        return null;
    }

    public String updateMovieScore(Long filmId, Long userId, FilmCommentRequest filmCommentRequest) {
        FilmComment filmComment= filmCommentRepository.findFilmCommentByFilm_IdAndUser_Id(filmId,userId);
        if(isExist(filmId,userId) && Objects.nonNull(filmComment)){
            filmComment.setMovieScore(filmCommentRequest.getMovieScore());
            filmCommentRepository.save(filmComment);
            LOGGER.info(filmComment.getMovieScore()+MovieFriendConstant.UPDATED.getName()+filmCommentRequest.getMovieScore());
            return "Updated !";
        }
        return "Not Updated!";
    }

    public String deleteFilmComment(Long filmId, Long userId) {
        FilmComment filmComment=filmCommentRepository.findFilmCommentByFilm_IdAndUser_Id(filmId,userId);
        if(Objects.nonNull(filmComment)){
            filmCommentRepository.deleteById(filmComment.getId());
            return "Deleted !";
        }
        return "Not Deleted !";
    }
    private boolean isExist(Long filmId, Long userId){
        List<FilmComment> films=filmCommentRepository.findAll();
        for(FilmComment filmComment:films){
            if((filmComment.getFilm().getId().equals(filmId)) && (filmComment.getUser().getId().equals(userId))){
                return true;
            }
        }
        return false;
    }
}
