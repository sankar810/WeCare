package com.fitbit.authentication;

import android.content.Intent;

import java.util.Set;

/**
 * Created by sanka on 4/8/2018.
 */

//clas for configuring authentication
public class AuthenticationConfiguration {

    private ClientCredentials clientCredentials;
    private Set<Scope> requiredScopes;
    private Set<Scope> optionalScopes;
    private Intent beforeLoginActivity;
    private boolean logoutOnAuthFailure;
    private RequestSigner requestSigner;
    private String encryptionKey;
    private Long tokenExpiresIn;

    AuthenticationConfiguration() {
        //Package only!
    }

    //get credentials of client
    public ClientCredentials getClientCredentials() {
        return clientCredentials;
    }

    //assign client credentials
    void setClientCredentials(ClientCredentials clientCredentials) {
        this.clientCredentials = clientCredentials;
    }

    //return requrred scope
    public Set<Scope> getRequiredScopes() {
        return requiredScopes;
    }

    //assign required scope
    void setRequiredScopes(Set<Scope> requiredScopes) {
        this.requiredScopes = requiredScopes;
    }

    //return optional scopes
    public Set<Scope> getOptionalScopes() {
        return optionalScopes;
    }

    //assign optional scopes
    void setOptionalScopes(Set<Scope> optionalScopes) {
        this.optionalScopes = optionalScopes;
    }

    //before login activity
    public Intent getBeforeLoginActivity() {
        return beforeLoginActivity;
    }

    //set before login activity
    void setBeforeLoginActivity(Intent beforeLoginActivity) {
        this.beforeLoginActivity = beforeLoginActivity;
    }

    //logout authorization fail
    public boolean isLogoutOnAuthFailure() {
        return logoutOnAuthFailure;
    }

    //assign logout authorization failed
    public void setLogoutOnAuthFailure(boolean logoutOnAuthFailure) {
        this.logoutOnAuthFailure = logoutOnAuthFailure;
    }

    //return signed
    public RequestSigner getRequestSigner() {
        return requestSigner;
    }

    //assign request signer
    void setRequestSigner(RequestSigner requestSigner) {
        this.requestSigner = requestSigner;
    }

    //return encryption key
    public String getEncryptionKey() {
        return encryptionKey;
    }

    //assign encryption key
    void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    //get token expires time
    public Long getTokenExpiresIn() {
        return tokenExpiresIn;
    }

    //assign token expires time
    void setTokenExpiresIn(Long tokenExpiresIn) {
        this.tokenExpiresIn = tokenExpiresIn;
    }
}
