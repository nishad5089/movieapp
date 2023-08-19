package com.netflix.movieapp.domain.request.movie;

import jakarta.validation.constraints.Positive;
import lombok.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieFilterRequest {

    private String title;
    private Integer releaseYear;
}
