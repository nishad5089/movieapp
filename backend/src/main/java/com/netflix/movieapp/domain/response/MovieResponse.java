package com.netflix.movieapp.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieResponse {

    private Long id;

    private String title;

    private String description;

    @JsonProperty("release_year")
    private String releaseYear;

    private Set<String> genres;
}
