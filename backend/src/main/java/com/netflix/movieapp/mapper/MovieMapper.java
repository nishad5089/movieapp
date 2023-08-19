package com.netflix.movieapp.mapper;

import com.netflix.movieapp.domain.entity.Genre;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import com.netflix.movieapp.domain.request.movie.MovieUpdateRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mappings({
         @Mapping(target = "genres", ignore = true)
    })
    Movie toEntity(MovieCreateRequest request);

    default Genre createGenreFromName(String genreName) {
       return Genre.builder().name(genreName).build();
    }

    @Mapping(target = "genres", expression = "java(mapGenresToGenreNames(entity.getGenres()))")
    MovieResponse toResponse(Movie entity);

    default Set<String> mapGenresToGenreNames(Set<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }

    void updateEntity(MovieUpdateRequest request, @MappingTarget Movie entity);

}
