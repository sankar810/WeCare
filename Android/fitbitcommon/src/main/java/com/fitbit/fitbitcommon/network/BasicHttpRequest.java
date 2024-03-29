package com.fitbit.fitbitcommon.network;

import android.support.v4.util.Pair;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanka on 4/8/2018.
 */

//http request handler
public class BasicHttpRequest {

    private String url;
    private String authorization;
    private String method;
    private String contentType;
    private byte[] content;
    private boolean useCaches;
    private List<Pair<String, String>> params;

    BasicHttpRequest() {

    }

    //return url string
    public String getUrl() {
        return url;
    }

    //assign url string
    void setUrl(String url) {
        this.url = url;
    }

    //return authorization
    void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    //return method
    public String getMethod() {
        return method;
    }

    //assign method
    void setMethod(String method) {
        this.method = method;
    }

    //return content type
    public String getContentType() {
        return contentType;
    }

    //assign content type
    void setContentType(String contentType) {
        this.contentType = contentType;
    }

    //return length of content
    public int getContentLength() {
        return content != null ? content.length : 0;
    }

    //assign content
    void setContent(byte[] content) {
        this.content = content;
    }

    //assign content
    void setContent(String content) throws UnsupportedEncodingException {
        setContent(content.getBytes("UTF-8"));
    }

    //method for returing caches
    public boolean useCaches() {
        return useCaches;
    }

    //assign caches
    void setUseCaches(boolean useCaches) {
        this.useCaches = useCaches;
    }

    //assign parameters
    void setParams(List<Pair<String, String>> params) {
        this.params = params;
    }

    //return list
    public List<Pair<String, String>> getParams() {
        return params;
    }

    //method for url connection content addition
    private synchronized void fillInConnectionInfo(HttpURLConnection connection) throws IOException {
        connection.setRequestMethod(method);

        if (!TextUtils.isEmpty(authorization)) {
            connection.setRequestProperty("Authorization", authorization);
        }

        if (!TextUtils.isEmpty(contentType)) {
            connection.setRequestProperty("Content-Type", contentType);
        }

        if (content == null || content.length == 0) {
            connection.setRequestProperty("Content-Length", "0");
        } else {
            connection.setRequestProperty("Content-Length", Integer.toString(content.length));
            OutputStream outputStream = null;

            try {
                outputStream = connection.getOutputStream();
                outputStream.write(this.content);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
        connection.setUseCaches(this.useCaches);
    }

    //url query
    private String getQuery(List<Pair<String, String>> params) throws UnsupportedEncodingException {
        List<String> keyValues = new ArrayList<>();

        for (Pair<String, String> pair : params) {
            keyValues.add(
                    URLEncoder.encode(pair.first, "UTF-8")
                            + "="
                            + URLEncoder.encode(pair.second, "UTF-8")
            );
        }

        return TextUtils.join("&", keyValues);
    }

    //read data from buffer
    public byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }

    //synchronize http response
    public synchronized BasicHttpResponse execute() throws IOException {
        HttpURLConnection connection = null;

        String urlString = this.url + ((params != null) ? "?" + getQuery(this.params) : "");

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            fillInConnectionInfo(connection);
            connection.connect();

            return new BasicHttpResponse(
                    connection.getResponseCode(),
                    readBytes(connection.getInputStream())
            );

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
