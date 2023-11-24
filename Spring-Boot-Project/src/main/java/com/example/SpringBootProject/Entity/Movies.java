package com.example.SpringBootProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_acter")
    private String movieActer;
    @Column(name = "movie_lang")
    private String movieLang;
    public Movies(){

    }

    public Movies(long id,String movieName, String movieActer, String movieLang) {
        this.id = id;
        this.movieName = movieName;
        this.movieActer = movieActer;
        this.movieLang = movieLang;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieActer() {
        return movieActer;
    }

    public void setMovieActer(String movieActer) {
        this.movieActer = movieActer;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }
}
