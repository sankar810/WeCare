package com.fitbit.fitbitcommon.network;

import java.io.UnsupportedEncodingException;

/**
 * Created by sanka on 4/8/2018.
 */

//class for http response
public class BasicHttpResponse {

    private byte[] body;
    private int statusCode;

    //constructor
    public BasicHttpResponse() {
    }

    //constructor
    public BasicHttpResponse(int statusCode, byte[] body) {
        this.body = body;
        this.statusCode = statusCode;
    }

    //return http url body
    public byte[] getBody() {
        return body;
    }

    //assign body of url
    public void setBody(byte[] body) {
        this.body = body;
    }

    //return status code
    public int getStatusCode() {
        return statusCode;
    }

    //assign status code
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    //return body of url as string
    public String getBodyAsString() throws UnsupportedEncodingException {
        return new String(this.body, "UTF-8");
    }

    //return id successful
    public boolean isSuccessful() {
        return statusCode >= 100 && statusCode < 400;
    }
}
