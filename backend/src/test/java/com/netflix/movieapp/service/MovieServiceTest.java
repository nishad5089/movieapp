package com.netflix.movieapp.service;

import com.netflix.movieapp.Data;
import com.netflix.movieapp.common.domain.response.PagedResponse;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.request.movie.MovieFetchRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import com.netflix.movieapp.mapper.MovieMapper;
import com.netflix.movieapp.repository.GenreRepository;
import com.netflix.movieapp.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import static com.netflix.movieapp.Data.getMovieFetchRequest;
import static com.netflix.movieapp.Data.mockMovieList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository mockRepository;
    @Mock
    private GenreRepository mockGenreRepository;
    @Mock
    private MovieMapper mockMapper;

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieService(mockRepository, mockGenreRepository, mockMapper);
    }


    @Test
    void testGetAll() {

        final MovieFetchRequest fetchRequest = getMovieFetchRequest();

        final Page<Movie> movies = new PageImpl<>(mockMovieList());
        when(mockRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(movies);

        when(mockMapper.toResponse(any(Movie.class))).thenReturn(Data.mockMovieCreateResponse());

        final PagedResponse<MovieResponse> result = movieService.getAll(fetchRequest);

        assertEquals(mockMovieList().size(), result.getContent().size());

    }
}
