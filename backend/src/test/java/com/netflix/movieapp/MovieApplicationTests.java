package com.netflix.movieapp;

import com.netflix.movieapp.controller.MovieController;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class MovieApplicationTests {
    @Autowired
    private MovieController movieController;

    @Test
    void contextLoads() {
    }

    @Test
    void movie_test() {
        MovieCreateRequest movie = MovieCreateRequest.builder()
                .title("Titanic")
                .description("It is Romantic Movie")
                .releaseYear(2022)
                .genres(getGenre()).build();
        movieController.create(movie);
    }

    private Set<String> getGenre() {
        return new HashSet<>(Arrays.asList("Horror","Adventure"));
    }


}
