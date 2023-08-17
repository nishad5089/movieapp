package com.netflix.movieapp.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

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

    private String title;

    private String description;

    private String releaseYear;

    private List<String> genres;
}
