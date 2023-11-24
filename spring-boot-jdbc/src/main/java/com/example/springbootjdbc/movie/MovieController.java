package com.example.springbootjdbc.movie;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieDto>> movieList(){
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Custom-Header","Custom-Value");
        return new ResponseEntity<>(service.movieList(),responseHeader,200);
    }
    @GetMapping("{id}")
    public ResponseEntity<MovieDto> movieById(@PathVariable(value = "id") int id){
            return new ResponseEntity<>(service.getMovieById(id),HttpStatus.OK);
    }
    @PostMapping
    public void addMovie(@Valid @RequestBody MovieDto movie){
        service.addMovie(movie);
    }
    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable(value = "id") int id){
         service.deleteMovie(id);
    }
    @GetMapping("actor/{actorname}")
    public List<MovieName> getMovie(@PathVariable(value= "actorname")String actorname){
        return service.getMovies(actorname);
    }

}
