package com.netflix.movieapp.service;

import com.netflix.movieapp.domain.response.GenreResponse;
import com.netflix.movieapp.mapper.GenreMapper;
import com.netflix.movieapp.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class GenreService extends BaseService {

    private final GenreRepository repository;
    private final GenreMapper mapper;

    public Set<GenreResponse> getAll() {

        return repository.findAll().stream().map(mapper::toResponse)
                                            .collect(Collectors.toSet());
    }
}
