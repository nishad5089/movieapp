package com.netflix.movieapp.exceptions;

import com.netflix.movieapp.common.exceptions.RESTException;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class GenreNotFoundException extends RESTException {
    public GenreNotFoundException(String message) {
        super(message);
    }
}
