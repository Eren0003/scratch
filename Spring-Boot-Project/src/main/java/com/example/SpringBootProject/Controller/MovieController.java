package com.example.SpringBootProject.Controller;
import com.example.SpringBootProject.Entity.Movies;
import com.example.SpringBootProject.Repository.MoviesRepository;
import com.example.SpringBootProject.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("getAllMovie")
    public List<Movies> getAllMovie(){
       return movieService.getAllMovies();
    }
    @RequestMapping("{lang}")
    public List<Movies> getMovieByLang(@PathVariable (value ="lang")String lang){
        return movieService.getMoivesByLang(lang);
    }
    @PostMapping("addNewMovie")
    public Movies addNewMovie(@RequestBody Movies movie){
        return movieService.addNewMovie(movie);
    }

}
