package com.fitbit.authentication;

/**
 * Created by sanka on 4/8/2018.
 */

//class for handling url changes
public interface UrlChangeHandler {
    void onUrlChanged(String newUrl);
    void onLoadError(int errorCode, CharSequence description);
}
