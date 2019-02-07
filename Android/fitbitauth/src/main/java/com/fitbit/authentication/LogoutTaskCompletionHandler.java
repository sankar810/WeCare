package com.fitbit.authentication;

/**
 * Created by sanka on 4/8/2018.
 */
//interface for logout task completion
public interface LogoutTaskCompletionHandler {
    void logoutSuccess();

    void logoutError(String message);
}
