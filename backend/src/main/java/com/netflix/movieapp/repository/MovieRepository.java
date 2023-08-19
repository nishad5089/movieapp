package com.netflix.movieapp.repository;

import com.netflix.movieapp.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    boolean existsByTitleIgnoreCase(String title);

    Optional<Movie> findByTitleIgnoreCase(String title);
}
