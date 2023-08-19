package com.netflix.movieapp.domain.request.movie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
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
public class MovieCreateRequest implements Serializable {

    @NotBlank(message = "{validation.constraints.movie.title.empty}")
    @Size(min = 4, max = 50, message = "{validation.constraints.movie.title.size}")
    private String title;

    @Size(min = 4, max = 300, message = "{validation.constraints.movie.title.size}")
    @NotBlank(message = "{validation.constraints.movie.description.empty}")
    private String description;

    @NotNull(message = "{validation.constraints.movie.releaseYear.NotNull}")
    private Integer releaseYear;

    @NotNull(message = "{validation.constraints.movie.genres.NotNull}")
    private Set<String> genres;
}
