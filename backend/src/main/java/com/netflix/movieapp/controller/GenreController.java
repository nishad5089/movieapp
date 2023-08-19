package com.netflix.movieapp.controller;

import com.netflix.movieapp.common.domain.response.ApiResponse;
import com.netflix.movieapp.common.utils.ResponseUtil;
import com.netflix.movieapp.domain.response.GenreResponse;
import com.netflix.movieapp.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

import static com.netflix.movieapp.common.enums.ResponseMessages.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController extends BaseController {

    private final GenreService genreService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResponse<Set<GenreResponse>>> get() {

        return ResponseUtil.createResponse(HttpStatus.OK,
                getMessage(GENRE_RETRIEVED_SUCCESSFULLY), genreService.getAll());
    }

}
