package com.netflix.movieapp.common.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

    private HttpStatus status;
    private String message;

    public BaseResponse setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
