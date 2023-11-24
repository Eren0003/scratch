package com.example.springbootjdbc.movie;

import com.example.springbootjdbc.actor.Actor;
import com.example.springbootjdbc.actor.ActorDao;
import com.example.springbootjdbc.exception.IdNotFoundException;
import com.example.springbootjdbc.movieactor.MovieActor;
import com.example.springbootjdbc.movieactor.MovieActorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ActorDao actorDao;
    @Autowired
    private MovieActorDao movieActorDao;
    public List<MovieDto> movieList(){
         if(movieDao.selectMovies().isEmpty()){
             throw new IdNotFoundException("No Movies Added To The List");
         }else{
             return movieDao.selectMovies().stream().map(Movie::getId).map((a) -> {
                 Optional<Movie> movie = movieDao.selectMovieById(a);
                 MovieDto dto = MovieDto.builder()
                         .actors(movieActorDao.getActor(a).stream().map((c) -> {
                             return new Actor(c.actorname());
                         }).collect(Collectors.toList()))
                         .moviename(movie.get().getMoviename())
                         .id(movie.get().getId())
                         .releaseDate(movie.get().getReleaseDate())
                         .build();
                 return dto;
             }).collect(Collectors.toList());
         }
    }
    public MovieDto getMovieById(int id){
        Optional<Movie> movie =  movieDao.selectMovieById(id);
        if(movie.isEmpty()){
            throw new IdNotFoundException("Id : " + id + " not Found");
        }
        else{
            return MovieDto.builder().id(id).moviename(movie.get().getMoviename())
                    .actors(movieActorDao.getActor(id).stream().map(a->{
                        return new Actor(a.actorname());})
                            .collect(Collectors.toList())).releaseDate(movie.get().getReleaseDate()).build();
        }
    }
    public void addMovie(MovieDto movie){
//        if(movie.id == 0 || movie.actors.stream().anyMatch(a -> a.getActorname() == null ) ||
//                movie.moviename == null ||
//                movie.releaseDate == null ||
//                movie.actors.stream().anyMatch(a -> a.getActorname().length() == 0)
//                || movie.moviename.isEmpty()
//        ){
//            throw new IdNotFoundException("Give all the data..!");
//        }else{
            Optional<Movie> data = movieDao.selectMovieById(movie.id);
            Optional<Movie> dataName = movieDao.selectMovieByName(movie.moviename);
            if (data.isPresent()){
                throw new IdNotFoundException("MovieId : "+movie.id + " already Exist.");
            }else if(dataName.isPresent()){
                throw new IdNotFoundException("Moviename : " +movie.moviename + " already Exist.");
            }
            else{
                movieDao.insertMovie(movie);
                movie.actors.stream().filter((a) -> {
                    movieActorDao.insertMovieActor(movie.id, a);
                    return actorDao.findActorByName(a.getActorname()).isEmpty();
                }).forEach(a -> actorDao.insertActor(a));
            }
//        }
    }
    public void deleteMovie(int id) {
        Optional<Movie> movie = movieDao.selectMovieById(id);
;        if(movie.isEmpty()){
            throw new IdNotFoundException("Id :"+id +" not Found");
        }else{
            movieDao.deleteMovie(id);
            movieActorDao.deleteMovieActor(id);
        }
    }
    public List<MovieName> getMovies(String actorname) {
        if(actorDao.findActorByName(actorname).isEmpty() ){
            throw new IdNotFoundException("Actorname : "+ actorname+" Doesn't Exist !");
        }else{
            return movieActorDao.getMovie(actorname).stream()
                    .map(MovieActor::movieid).toList()
                    .stream().map(i -> new MovieName(movieDao.selectMovieById(i).get().getMoviename()))
                    .collect(Collectors.toList());
        }
    }
}

