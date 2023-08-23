package com.netflix.movieapp.common.exceptions;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class RecordNotFoundException extends RESTException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
