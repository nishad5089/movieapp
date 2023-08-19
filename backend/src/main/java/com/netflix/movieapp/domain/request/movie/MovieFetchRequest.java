package com.netflix.movieapp.domain.request.movie;

import com.netflix.movieapp.common.domain.request.PaginationRequest;
import lombok.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieFetchRequest {
    private PaginationRequest pagination;
    private MovieFilterRequest filters;
}
