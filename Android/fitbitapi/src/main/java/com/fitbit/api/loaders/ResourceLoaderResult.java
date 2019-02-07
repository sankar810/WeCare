package com.fitbit.api.loaders;

/**
 * Created by sanka on 4/8/2018.
 */

//resourceloader result class
public class ResourceLoaderResult<T> {
    private final T result;
    private final boolean successful;
    private final Exception exception;
    private final String errorMessage;
    private final ResultType resultType;

    public enum ResultType {
        SUCCESS, ERROR, EXCEPTION, LOGGED_OUT
    }

    //the type of resource loaded is saved in the variables
    private ResourceLoaderResult(T result, ResultType resultType, String errorMessage, Exception exception) {
        this.result = result;
        this.successful = resultType == ResultType.SUCCESS;
        this.errorMessage = errorMessage;
        this.exception = exception;
        this.resultType = resultType;
    }

    //onsuccess resource loader
    public static <G> ResourceLoaderResult<G> onSuccess(G result) {
        return new ResourceLoaderResult<G>(result, ResultType.SUCCESS, null, null);
    }
    //onerror resource loader
    public static <G> ResourceLoaderResult<G> onError(String errorMessage) {
        return new ResourceLoaderResult<G>(null, ResultType.ERROR, errorMessage, null);
    }
    //onexception resource loader
    public static <G> ResourceLoaderResult<G> onException(Exception exception) {
        String message = exception.getMessage();
        if (message == null) {
            message = exception.getCause().getMessage();
        }
        return new ResourceLoaderResult<G>(null, ResultType.EXCEPTION, message, exception);
    }
    //onloggeout resource load
    public static <G> ResourceLoaderResult<G> onLoggedOut() {
        return new ResourceLoaderResult<G>(null, ResultType.LOGGED_OUT, null, null);
    }
    //gets result based to resource
    public T getResult() {
        return result;
    }
    //issuccessful method
    public boolean isSuccessful() {
        return successful;
    }
    //returns error message
    public String getErrorMessage() {
        return errorMessage;
    }
    //returns exception
    public Exception getException() {
        return exception;
    }
    //returns result type
    public ResultType getResultType() {
        return resultType;
    }
}
