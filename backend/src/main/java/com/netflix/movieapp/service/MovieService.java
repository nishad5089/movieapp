package com.netflix.movieapp.service;

import com.netflix.movieapp.common.domain.response.PagedResponse;
import com.netflix.movieapp.domain.entity.Genre;
import com.netflix.movieapp.exceptions.GenreNotFoundException;
import com.netflix.movieapp.exceptions.MovieNotFoundException;
import com.netflix.movieapp.common.utils.PageUtil;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import com.netflix.movieapp.domain.request.movie.MovieFetchRequest;
import com.netflix.movieapp.domain.request.movie.UpdateMovieRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import com.netflix.movieapp.exceptions.MovieUpdateFailedException;
import com.netflix.movieapp.mapper.MovieMapper;
import com.netflix.movieapp.repository.GenreRepository;
import com.netflix.movieapp.repository.MovieRepository;
import com.netflix.movieapp.repository.specification.MovieSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.netflix.movieapp.constant.ResponseMessages.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class MovieService extends BaseService {

    private final MovieRepository repository;
    private final GenreRepository genreRepository;
    private final MovieMapper mapper;

    @Transactional
    public MovieResponse createMovie(MovieCreateRequest movieCreateRequest) {

        repository.findByTitleIgnoreCase(movieCreateRequest.getTitle().trim())
                .ifPresent(existingMovie -> {
                    throw new MovieNotFoundException(getMessage(MOVIE_ALREADY_EXIST));
                });

        if (checkGenresNotExist(movieCreateRequest.getGenres())) {
            throw new GenreNotFoundException(getMessage(GENRE_NOT_FOUND));
        }

        Movie movie = mapper.toEntity(movieCreateRequest);
        Set<Genre> genres = genreRepository.findAllByNameIn(movieCreateRequest.getGenres());
        movie.setGenres(genres);
        Movie savedMovie = repository.save(movie);
        return mapper.toResponse(savedMovie);
    }

    public PagedResponse<MovieResponse> getAll(MovieFetchRequest fetchRequest) {

        Page<Movie> todos = repository.findAll(MovieSpecification.criteriaFilter(fetchRequest.getFilters()), PageUtil.getPageable(fetchRequest.getPagination()));
        return PageUtil.paginate(todos, mapper::toResponse);
    }


    private boolean checkGenresNotExist(Set<String> genreNames) {
        return genreNames.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .anyMatch(genreName -> !genreRepository.existsByNameIgnoreCase(genreName));
    }

    public MovieResponse getDetails(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new MovieNotFoundException(getMessage(MOVIE_NOT_FOUND)));
    }


    @Transactional
    public MovieResponse update(UpdateMovieRequest updateMovieRequest) {
        Movie movie = repository.findById(updateMovieRequest.getId())
                .orElseThrow(() -> new MovieNotFoundException(getMessage(MOVIE_NOT_FOUND)));

        if (checkGenresNotExist(updateMovieRequest.getGenres())) {
            throw new GenreNotFoundException(getMessage(GENRE_NOT_FOUND));
        }

        try {
            mapper.updateEntity(updateMovieRequest, movie);

            Set<Genre> updatedGenres = updateGenres(updateMovieRequest.getGenres(), movie.getGenres());
            movie.setGenres(updatedGenres);

            Movie updatedMovie = repository.save(movie);
            return mapper.toResponse(updatedMovie);
        } catch (Exception ex) {
            throw new MovieUpdateFailedException(getMessage(MOVIE_UPDATE_FAILED));
        }
    }

    private Set<Genre> updateGenres(Set<String> newGenreNames, Set<Genre> existingGenres) {
        Set<Genre> updatedGenres = genreRepository.findAllByNameIn(existingGenres.stream().map(Genre::getName).collect(Collectors.toSet()));

        updatedGenres.removeIf(existingGenre -> !newGenreNames.contains(existingGenre.getName()));

        for (String newGenreName : newGenreNames) {
            boolean containsGenre = updatedGenres.stream()
                    .anyMatch(existingGenre -> existingGenre.getName().equals(newGenreName));

            if (!containsGenre) {
                Genre newGenre = genreRepository.findByName(newGenreName)
                                                .orElseThrow(() -> new GenreNotFoundException(getMessage(GENRE_NOT_FOUND)));
                updatedGenres.add(newGenre);
            }
        }

        return updatedGenres;
    }



}
