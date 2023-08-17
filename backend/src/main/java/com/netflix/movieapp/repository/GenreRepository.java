package com.netflix.movieapp.repository;

import com.netflix.movieapp.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
