package com.netflix.movieapp.controller;

import com.netflix.movieapp.common.domain.response.ApiResponse;
import com.netflix.movieapp.common.domain.response.PagedResponse;
import com.netflix.movieapp.common.utils.ResponseUtil;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import com.netflix.movieapp.domain.request.movie.MovieFetchRequest;
import com.netflix.movieapp.domain.request.movie.UpdateMovieRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import com.netflix.movieapp.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.netflix.movieapp.constant.ResponseMessages.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController extends BaseController {

    private final MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<MovieResponse>> create(@Valid @RequestBody MovieCreateRequest request) {
        MovieResponse createdMovie = movieService.createMovie(request);
        return ResponseUtil.createResponse(HttpStatus.CREATED,
                getMessage(MOVIE_CREATED_SUCCESSFULLY),
                createdMovie);
    }

    @PostMapping("/get/all")
    public ResponseEntity<ApiResponse<PagedResponse<MovieResponse>>> getAll(@RequestBody MovieFetchRequest fetchRequest) {
        PagedResponse<MovieResponse> movies = movieService.getAll(fetchRequest);
        return ResponseUtil.createResponse(HttpStatus.OK,
                getMessage(MOVIE_RETRIEVED_SUCCESSFULLY), movies);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<MovieResponse>> get(@PathVariable Long id) {

        return ResponseUtil.createResponse(HttpStatus.OK,
                getMessage(MOVIE_RETRIEVED_SUCCESSFULLY), movieService.getDetails(id));
    }

    @PutMapping ("/update")
    public ResponseEntity<ApiResponse<MovieResponse>> update(@Valid @RequestBody UpdateMovieRequest updateMovieRequest) {

        return ResponseUtil.createResponse(HttpStatus.OK, getMessage(MOVIE_UPDATED_SUCCESSFULLY), movieService.update(updateMovieRequest));
    }

}
