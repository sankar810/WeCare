package com.fitbit.fitbitcommon.network;

import android.support.v4.util.Pair;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by sanka on 4/8/2018.
 */

//http request builder handler
public class BasicHttpRequestBuilder {

    private BasicHttpRequest basicHttpRequest;

    //constructor
    public static BasicHttpRequestBuilder create() {
        return new BasicHttpRequestBuilder();
    }

    //check url
    public BasicHttpRequest build() {
        if (TextUtils.isEmpty(basicHttpRequest.getUrl())) {
            throw new IllegalArgumentException("Url cannot be empty!");
        }
        return basicHttpRequest;

    }

    //get url
    private BasicHttpRequestBuilder() {
        basicHttpRequest = new BasicHttpRequest();
        basicHttpRequest.setMethod("GET");
    }

    //assign url
    public BasicHttpRequestBuilder setUrl(String url) {
        basicHttpRequest.setUrl(url);
        return this;
    }

    //assign authorization for url
    public BasicHttpRequestBuilder setAuthorization(String authorization) {
        basicHttpRequest.setAuthorization(authorization);
        return this;
    }

    //assign method to access
    public BasicHttpRequestBuilder setMethod(String method) {
        basicHttpRequest.setMethod(method);
        return this;
    }

    //assign content type
    public BasicHttpRequestBuilder setContentType(String contentType) {
        basicHttpRequest.setContentType(contentType);
        return this;
    }

    //assign content
    public BasicHttpRequestBuilder setContent(String content) throws UnsupportedEncodingException {
        basicHttpRequest.setContent(content);
        return this;
    }

    //assign byte content type
    public BasicHttpRequestBuilder setContent(byte[] content) {
        basicHttpRequest.setContent(content);
        return this;
    }

    //assign caches
    public BasicHttpRequestBuilder setUseCaches(boolean useCaches) {
        basicHttpRequest.setUseCaches(useCaches);
        return this;
    }

    //add query parameters
    public BasicHttpRequestBuilder addQueryParam(String name, String value) {
        if (basicHttpRequest.getParams() == null) {
            basicHttpRequest.setParams(new ArrayList<Pair<String, String>>());
        }

        basicHttpRequest.getParams().add(new Pair<String, String>(name, value));
        return this;
    }
}
