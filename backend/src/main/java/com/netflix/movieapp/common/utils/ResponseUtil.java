package com.netflix.movieapp.common.utils;


import com.netflix.movieapp.common.domain.response.ApiResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public final class ResponseUtil {
	
	public <T> ResponseEntity<ApiResponse<T>> createResponse(HttpStatus status, String message, T response) {
		return ResponseEntity.status(status)
		                     .body(createResponseBody(message, response));
	}

	private <T> ApiResponse<T> createResponseBody(String message, T response) {
		return ApiResponse.<T>apiResponseBuilder()
		                  .message(message)
		                  .data(response)
		                  .build();
	}
}
