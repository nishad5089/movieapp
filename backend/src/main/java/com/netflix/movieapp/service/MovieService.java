package com.netflix.movieapp.service;

import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    public Movie createMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }
}
