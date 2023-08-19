package com.netflix.movieapp.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorBaseResponse extends BaseResponse {

    private List<Error> errors;
    public ErrorBaseResponse(HttpStatus status, String message, List<Error> errors) {
        setStatus(status);
        setMessage(message);
        this.errors = errors;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Error {
        private String field;
        private String message;
    }
    public ErrorBaseResponse setStatus(HttpStatus status) {
        super.setStatus(status);
        return this;
    }

    public ErrorBaseResponse setMessage(String message) {
        super.setMessage(message);
        return this;
    }
}
