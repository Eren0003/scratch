package com.example.springbootjdbc.movieactor;

import com.example.springbootjdbc.actor.Actor;
import com.example.springbootjdbc.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieActorDao {
    void insertMovieActor(int movie,Actor actor);
    List<MovieActor> getActor(int movieid);
    void deleteMovieActor(int movieid);
    List<MovieActor> getMovie(String actorname);
}
