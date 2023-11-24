package com.example.springbootjdbc.movieactor;

import com.example.springbootjdbc.actor.Actor;
import com.example.springbootjdbc.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieActorDataAccessService implements MovieActorDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insertMovieActor(int movieId, Actor actor) {
        String sql = """
                INSERT INTO movieactor(movieid,actorname)
                VALUES(?,?)
                """;
        jdbcTemplate.update(sql,movieId,actor.getActorname());
    }

    @Override
    public List<MovieActor> getActor(int movieid) {
        String sql = """
                SELECT actorname,movieid FROM movieactor
                WHERE movieid = ?
                """;
        return jdbcTemplate.query(sql, new MovieActorRowMapper(),movieid);
    }

    @Override
    public void deleteMovieActor(int movieid) {
        String sql = """
                DELETE FROM movieactor WHERE movieid = ?
                """;
         jdbcTemplate.update(sql,movieid);
    }

    @Override
    public List<MovieActor> getMovie(String actorname) {
        String sql = """
                SELECT actorname,movieid FROM movieactor
                WHERE actorname = ?
                """;
        return jdbcTemplate.query(sql,new MovieActorRowMapper(),actorname);
    }


}
