package com.netflix.movieapp.common.handlers;


import com.netflix.movieapp.common.domain.response.ApiResponse;
import com.netflix.movieapp.common.domain.response.ErrorBaseResponse;
import com.netflix.movieapp.common.exceptions.RESTException;
import com.netflix.movieapp.common.utils.ResponseUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@RestControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<ApiResponse<String>> handleAllExceptions(Exception ex) {
		return ResponseUtil.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
	}
	
	@ExceptionHandler (RESTException.class)
	public ResponseEntity<ApiResponse<Map<String, String>>> handleRESTException(RESTException exception) {
		Map<String, String> payload = exception.getPayload() == null ? null :
				exception.getPayload()
				         .entrySet()
				         .stream()
				         .collect(HashMap::new,
				                  (map, entry) -> map.put(entry.getKey(),
				                                          entry.getValue()
				                                               .toString()),
				                  Map::putAll);
		
		return ResponseUtil.createResponse(exception.getStatus(),
		                                   exception.getMessage(),
		                                   payload);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ErrorBaseResponse.Error> errors = new ArrayList<>();
		ex.getBindingResult()
				.getFieldErrors()
				.forEach(error -> errors
						.add(new ErrorBaseResponse.Error(error.getField(), error.getDefaultMessage())));
		ex.getBindingResult()
				.getGlobalErrors()
				.forEach(error -> errors
						.add(new ErrorBaseResponse.Error(error.getObjectName(), error.getDefaultMessage())));

		ErrorBaseResponse errorResponse = new ErrorBaseResponse(HttpStatus.valueOf(status.value()), "Invalid request body", errors);
		return handleExceptionInternal(ex, errorResponse, headers, errorResponse.getStatus(), request);
	}
	
}
