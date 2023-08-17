package com.netflix.movieapp.mapper;

import com.netflix.movieapp.domain.entity.Genre;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.request.MovieCreateRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "genres", expression = "java(this.mapStringListToGenreList(request.getGenres()))")
    Movie toEntity(MovieCreateRequest request);

    default List<Genre> mapStringListToGenreList(List<String> genres) {
        return genres.stream()
                .map(this::createGenreFromName)
                .collect(Collectors.toList());
    }

    default Genre createGenreFromName(String genreName) {
       return Genre.builder().name(genreName).build();
    }

    @Mapping(target = "genres", expression = "java(mapGenresToGenreNames(entity.getGenres()))")
    MovieResponse toResponse(Movie entity);

    default List<String> mapGenresToGenreNames(List<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toList());
    }
}
