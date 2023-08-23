package com.netflix.movieapp.common.exceptions;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class AlreadyExistException  extends RESTException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
