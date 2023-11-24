package com.example.SpringBootProject.Repository;

import com.example.SpringBootProject.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class MoviesRepository implements JpaRepository<Movies,Long> {
}
