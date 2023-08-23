package com.netflix.movieapp.exceptions;

import com.netflix.movieapp.common.exceptions.RESTException;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class MovieCreateFailedException extends RESTException {
    public MovieCreateFailedException(String message) {
        super(message);
    }
}
