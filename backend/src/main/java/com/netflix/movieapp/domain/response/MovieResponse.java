package com.netflix.movieapp.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieResponse {

    private Long id;

    private String title;

    private String description;

    private Integer releaseYear;

    private Set<String> genres;
}
