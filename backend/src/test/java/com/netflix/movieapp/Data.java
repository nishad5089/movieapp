package com.netflix.movieapp;

import com.netflix.movieapp.common.domain.request.PaginationRequest;
import com.netflix.movieapp.common.domain.response.PagedResponse;
import com.netflix.movieapp.domain.entity.Genre;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import com.netflix.movieapp.domain.request.movie.MovieFetchRequest;
import com.netflix.movieapp.domain.request.movie.MovieFilterRequest;
import com.netflix.movieapp.domain.request.movie.MovieUpdateRequest;
import com.netflix.movieapp.domain.response.MovieResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class Data {

    public static Set<Genre> getGenres() {
        return Set.of(
                Genre.builder().id(1L).name("Action").build(),
                Genre.builder().id(2L).name("Romantic").build(),
                Genre.builder().id(3L).name("Horror").build(),
                Genre.builder().id(4L).name("Adventure").build()
        );
    }


    public static Set<String> getGenreNameList() {
        return Set.of("Action", "Romantic");
    }

    public static MovieResponse mockMovieCreateResponse() {
        return MovieResponse.builder()
                .id(1L)
                .title("Breaking Bad")
                .description("You know the business and I know the coding")
                .releaseYear(2019)
                .genres(getGenreNameList()).build();
    }

    public static List<MovieResponse> mockMovieFetchResponse() {

        return Arrays.asList(MovieResponse.builder().id(1L).title("Breaking Bad")
                        .description("You know the business and I know the coding")
                        .genres(Set.of("Action", "Romantic"))
                        .releaseYear(2019)
                        .build(),
                MovieResponse.builder().id(2L).title("Titanic")
                        .description("Movie Description")
                        .genres(Set.of("Action", "Adventure"))
                        .releaseYear(2022)
                        .build());
    }

    public static List<Movie> mockMovieList() {

        return Arrays.asList(
                Movie.builder().id(1L).title("Breaking Bad")
                        .description("You know the business and I know the coding")
                        .genres(Set.of(Genre.builder()
                                .id(1L)
                                .name("Action")
                                .build(), Genre.builder()
                                .id(2L)
                                .name("Adventure")
                                .build()))
                        .releaseYear(2019)
                        .build(),
                Movie.builder().id(2L).title("Titanic")
                        .description("Movie Description")
                        .genres(Set.of(Genre.builder()
                                .id(1L)
                                .name("Horror")
                                .build(), Genre.builder()
                                .id(2L)
                                .name("Action")
                                .build()))
                        .releaseYear(2022)
                        .build());
    }

    public static <T> PagedResponse<T> mockPaginatedResponse(List<T> content) {

        return PagedResponse.<T>builder()
                .content(content)
                .page(1)
                .size(5)
                .totalPages(1)
                .totalItems(content.size())
                .build();
    }

    public static MovieFetchRequest getMovieFetchRequest() {
        PaginationRequest pagination = PaginationRequest.builder()
                .page(1)
                .size(5)
                .sorts(new String[]{"id,desc"})
                .build();

        // filter by title or release year
        MovieFilterRequest filters = MovieFilterRequest.builder()
                .title("")
                .build();

        return MovieFetchRequest.builder()
                .pagination(pagination)
                .filters(filters)
                .build();
    }

    public static MovieCreateRequest getMovieCreateRequest() {
        return MovieCreateRequest.builder()
                .title("Breaking Bad")
                .description("You know the business and I know the coding")
                .releaseYear(2019)
                .genres(Set.of("Action", "Romantic")).build();
    }

    public static MovieUpdateRequest getMovieUpdateRequest() {
        return MovieUpdateRequest.builder()
                .id(1L)
                .title("Breaking Bad")
                .description("You know the business and I know the coding")
                .releaseYear(2019)
                .genres(Set.of("Action", "Romantic")).build();
    }

}



