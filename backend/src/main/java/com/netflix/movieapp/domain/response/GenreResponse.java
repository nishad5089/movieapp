package com.netflix.movieapp.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Builder
@Getter
@Setter
public class GenreResponse {
    private String name;
}
