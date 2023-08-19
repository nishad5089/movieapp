package com.netflix.movieapp.mapper;

import com.netflix.movieapp.domain.entity.Genre;
import com.netflix.movieapp.domain.response.GenreResponse;
import org.mapstruct.Mapper;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreResponse toResponse(Genre entity);
}
