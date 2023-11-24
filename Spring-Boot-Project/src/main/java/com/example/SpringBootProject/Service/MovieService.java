package com.example.SpringBootProject.Service;

import com.example.SpringBootProject.Entity.Movies;
import com.example.SpringBootProject.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MovieService {
    @Autowired
    MoviesRepository moviesRepository;

    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }
    public List<Movies> getMoivesByLang(String lang){
        List<Movies> allMovies = moviesRepository.findAll();
        List<Movies> expectedMovie = new ArrayList<>();
        for(Movies movies : allMovies){
            if(movies.getMovieLang().equalsIgnoreCase(lang)){
                expectedMovie.add(movies);
            }
        }
        return expectedMovie;
    }
    public Movies addNewMovie(Movies movie){
        movie.setId(idGenerator());
        return moviesRepository.save(movie);
    }
    public long idGenerator(){
      return  moviesRepository.count()+1;
    }

}
