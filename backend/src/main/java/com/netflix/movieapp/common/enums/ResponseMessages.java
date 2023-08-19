package com.netflix.movieapp.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum ResponseMessages {

	GENERIC_ERROR_RESPONSE("Cannot perform the requested operation"),

	// Movie Message
	MOVIE_CREATED_SUCCESSFULLY("movie.saved.successfully"),
	MOVIE_RETRIEVED_SUCCESSFULLY("movie.retrieved.successfully"),
	MOVIE_UPDATED_SUCCESSFULLY("movie.update.successfully"),
	MOVIE_DELETED_SUCCESSFULLY("movie.deleted.successfully"),
	MOVIE_CREATE_FAILED("movie.saved.failed"),
	MOVIE_NOT_FOUND("movie.not.found"),
	MOVIE_ALREADY_EXIST("movie.already.exist"),
	MOVIE_DELETE_FAILED("movie.delete.failed"),
	MOVIE_UPDATE_FAILED("movie.update.failed"),

	GENRE_NOT_FOUND("genre.not.found"),
	GENRE_RETRIEVED_SUCCESSFULLY("genre.retrieved.successfully");

	private final String message;
}
