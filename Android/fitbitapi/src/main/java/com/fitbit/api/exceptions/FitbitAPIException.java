package com.fitbit.api.exceptions;

/**
 * Created by sanka on 4/8/2018.
 */

//handles exception in api
public class FitbitAPIException extends RuntimeException {

    public FitbitAPIException() {
    }

    public FitbitAPIException(String message) {
        super(message);
    }
}
