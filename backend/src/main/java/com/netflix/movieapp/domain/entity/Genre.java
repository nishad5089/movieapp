package com.netflix.movieapp.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Entity
@Table (name = "genre", schema = "public")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;
}
