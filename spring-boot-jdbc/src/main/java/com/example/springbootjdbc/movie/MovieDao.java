package com.example.springbootjdbc.movie;

import com.example.springbootjdbc.movieactor.MovieActor;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    Optional<Movie> selectMovieById(int id);
    int insertMovie(MovieDto movie);
    void deleteMovie(int id);
    Optional<Movie> selectMovieByName(String moviename);
}
