package com.netflix.movieapp.domain.request.movie;

import com.netflix.movieapp.common.domain.request.PaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieFetchRequest {
    private PaginationRequest pagination;
    private MovieFilterRequest filters;
}
