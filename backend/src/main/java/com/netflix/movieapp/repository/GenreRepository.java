package com.netflix.movieapp.repository;

import com.netflix.movieapp.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>, JpaSpecificationExecutor<Genre> {

    boolean existsByNameIgnoreCase(String name);

    Optional<Genre> findByName(String name);

    Set<Genre> findAllByNameIn(Set<String> nameList);
}
