package com.netflix.movieapp.controller;

import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.service.MovieService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@RestController
@RequestMapping("/message")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
}
