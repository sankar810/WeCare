package com.fitbit.authentication;

import android.content.Intent;
import android.text.TextUtils;

import java.util.HashSet;

/**
 * Created by sanka on 4/8/2018.
 */

//authentication configuraion builder class
public class AuthenticationConfigurationBuilder {

    private AuthenticationConfiguration authenticationConfiguration;
    private boolean hasSetClientCredentials = false;

    //constructor
    public AuthenticationConfigurationBuilder() {
        authenticationConfiguration = new AuthenticationConfiguration();

        //Set default values
        authenticationConfiguration.setRequiredScopes(new HashSet<Scope>());
        authenticationConfiguration.setOptionalScopes(new HashSet<Scope>());
        authenticationConfiguration.setRequestSigner(new SimpleRequestSigner());
        authenticationConfiguration.setLogoutOnAuthFailure(false);
    }

    //assign client credientials
    public AuthenticationConfigurationBuilder setClientCredentials(ClientCredentials clientCredentials) {
        this.authenticationConfiguration.setClientCredentials(clientCredentials);
        hasSetClientCredentials = clientCredentials != null && clientCredentials.isComplete();
        return this;
    }

    //add required resources
    public AuthenticationConfigurationBuilder addRequiredScopes(Scope... requiredScopes) {
        for (Scope scope : requiredScopes) {
            authenticationConfiguration.getRequiredScopes().add(scope);
        }
        return this;
    }

    //add optional scopes
    public AuthenticationConfigurationBuilder addOptionalScopes(Scope... optionalScopes) {
        for (Scope scope : optionalScopes) {
            authenticationConfiguration.getOptionalScopes().add(scope);
        }
        return this;
    }

    //assign before logn activuty flags
    public AuthenticationConfigurationBuilder setBeforeLoginActivity(Intent beforeLoginActivity) {
        authenticationConfiguration.setBeforeLoginActivity(beforeLoginActivity);
        beforeLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        beforeLoginActivity.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        beforeLoginActivity.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        return this;
    }

    //assign logout authorization failure
    public AuthenticationConfigurationBuilder setLogoutOnAuthFailure(boolean loginOnAuthFailure) {
        authenticationConfiguration.setLogoutOnAuthFailure(loginOnAuthFailure);
        return this;
    }

    //assign request signer
    public AuthenticationConfigurationBuilder setRequestSigner(RequestSigner requestSigner) {
        authenticationConfiguration.setRequestSigner(requestSigner);
        return this;
    }

    //assign encryption key
    public AuthenticationConfigurationBuilder setEncryptionKey(String encryptionKey) {
        authenticationConfiguration.setEncryptionKey(encryptionKey);
        return this;
    }

    //assign token expiration time
    public AuthenticationConfigurationBuilder setTokenExpiresIn(Long tokenExpiresIn) {
        authenticationConfiguration.setTokenExpiresIn(tokenExpiresIn);
        return this;
    }

    //Exception handing
    public AuthenticationConfiguration build() {
        if (!hasSetClientCredentials) {
            throw new IllegalArgumentException("Error: client credentials not set! You must set client credentials with valid client id, client secret, and redirect url");
        } else if (authenticationConfiguration.getRequiredScopes().size()
                + authenticationConfiguration.getOptionalScopes().size() == 0) {
            throw new IllegalArgumentException("You must specify at least one oauth2 scope in `requiredScopes` or `optionalScopes`");
        } else if (TextUtils.isEmpty(authenticationConfiguration.getEncryptionKey())) {
            throw new IllegalArgumentException("Encryption Key must not be blank!");
        } else if (authenticationConfiguration.isLogoutOnAuthFailure() && authenticationConfiguration.getBeforeLoginActivity() == null) {
            throw new IllegalArgumentException("`BeforeLoginActivity must be set if auto-logout on auth failures");
        }

        return authenticationConfiguration;
    }


}
