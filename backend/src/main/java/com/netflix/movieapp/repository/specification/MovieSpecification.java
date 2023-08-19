package com.netflix.movieapp.repository.specification;

import com.netflix.movieapp.common.utils.SpecificationUtils;
import com.netflix.movieapp.domain.entity.Movie;
import com.netflix.movieapp.domain.entity.Movie_;
import com.netflix.movieapp.domain.request.movie.MovieFilterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class MovieSpecification {

    public static Specification<Movie> criteriaFilter(MovieFilterRequest filter) {

        Specification<Movie> specification =
                (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();

        specification = specification.and(filterByMovieTitle(filter.getTitle()));
        specification = specification.and(filterByReleaseYear(filter.getReleaseYear()));
        return specification;
    }

    private static Specification<Movie> filterByReleaseYear(Integer releaseYear) {

        return (root, query, cb) -> {
            if (releaseYear == null) {
                return null; // No filtering if releaseYear is null
            }
            return cb.equal(root.get(Movie_.RELEASE_YEAR), releaseYear);
        };
    }

    private static Specification<Movie> filterByMovieTitle(String title) {

        return (root, query, cb) -> {
            if (StringUtils.isEmpty(title)) {
                return null; // No filtering if title is empty or null
            }
            return cb.like(cb.lower(root.get(Movie_.TITLE)), SpecificationUtils.wildcardsAndLower(title));
        };
    }

}
