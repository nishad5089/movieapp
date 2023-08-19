package com.netflix.movieapp.exceptions;

import com.netflix.movieapp.common.exceptions.RESTException;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class MovieUpdateFailedException extends RESTException {
    public MovieUpdateFailedException(String message) {
        super(message);
    }
}
