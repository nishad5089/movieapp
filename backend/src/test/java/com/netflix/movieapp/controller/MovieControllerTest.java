package com.netflix.movieapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.movieapp.Data;
import com.netflix.movieapp.common.domain.response.PagedResponse;
import com.netflix.movieapp.common.enums.ResponseMessages;
import com.netflix.movieapp.domain.request.movie.MovieCreateRequest;
import com.netflix.movieapp.domain.request.movie.MovieFetchRequest;
import com.netflix.movieapp.domain.request.movie.MovieUpdateRequest;
import com.netflix.movieapp.domain.response.MovieResponse;
import com.netflix.movieapp.service.LocaleMessageService;
import com.netflix.movieapp.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @MockBean
    private LocaleMessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService mockMovieService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreate() throws Exception {

        when(mockMovieService.createMovie(any(MovieCreateRequest.class))).thenReturn(MovieResponse.builder().build());

        String requestBody = objectMapper.writeValueAsString(Data.getMovieCreateRequest());
        final MockHttpServletResponse response = mockMvc.perform(post("/api/movie/create")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }


    @Test
    void testGetAll() throws Exception {

        final PagedResponse<MovieResponse> movieResponsePagedResponse = Data.mockPaginatedResponse(Data.mockMovieFetchResponse());

        when(messageService.getLocalMessage(ResponseMessages.MOVIE_RETRIEVED_SUCCESSFULLY))
                .thenReturn("Movie retrieved successfully");
        when(mockMovieService.getAll(any(MovieFetchRequest.class))).thenReturn(movieResponsePagedResponse);
        String requestBody = objectMapper.writeValueAsString(Data.getMovieFetchRequest());

        final MockHttpServletResponse response = mockMvc.perform(post("/api/movie/get/all")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGet() throws Exception {

        when(mockMovieService.getDetails(1L)).thenReturn(Data.mockMovieCreateResponse());

        final MockHttpServletResponse response = mockMvc.perform(get("/api/movie/get/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testUpdate() throws Exception {

        when(mockMovieService.update(any(MovieUpdateRequest.class))).thenReturn(Data.mockMovieCreateResponse());

        String requestBody = objectMapper.writeValueAsString(Data.getMovieUpdateRequest());
        final MockHttpServletResponse response = mockMvc.perform(put("/api/movie/update")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
