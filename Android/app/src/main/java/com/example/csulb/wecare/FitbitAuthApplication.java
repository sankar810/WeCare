package com.example.csulb.wecare;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.fitbit.authentication.AuthenticationConfiguration;
import com.fitbit.authentication.AuthenticationConfigurationBuilder;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.ClientCredentials;
import com.fitbit.authentication.Scope;

import static com.fitbit.authentication.Scope.activity;

/**
 * Created by sanka on 4/10/2018.
 */

//Authentication of fitbit application
public class FitbitAuthApplication extends Application {

    /**
     * These client credentials come from creating an app on https://dev.fitbit.com.
     * <p>
     * To use with your own app, register as a developer at https://dev.fitbit.com, create an application,
     * set the "OAuth 2.0 Application Type" to "Client", enter a word for the redirect url as a url
     * (like `https://finished` or `https://done` or `https://completed`, etc.), and save.
     * <p>
     */

    //!! THIS SHOULD BE IN AN ANDROID KEYSTORE!! See https://developer.android.com/training/articles/keystore.html
    private static final String CLIENT_SECRET = "86401692efd006045a157f45755000d0";

    /**
     * This key was generated using the SecureKeyGenerator [java] class. Run as a Java application (not Android)
     * This key is used to encrypt the authentication token in Android user preferences. If someone decompiles
     * your application they'll have access to this key, and access to your user's authentication token
     */
    //!! THIS SHOULD BE IN AN ANDROID KEYSTORE!! See https://developer.android.com/training/articles/keystore.html
    private static final String SECURE_KEY = "CVPdQNAT6fBI4rrPLEn9x0+UV84DoqLFiNHpKOPLRW0=";

    /**
     * This method sets up the authentication config needed for
     * successfully connecting to the Fitbit API. Here we include our client credentials,
     * requested scopes, and  where to return after login
     */
    public static AuthenticationConfiguration generateAuthenticationConfiguration(Context context, Class<? extends Activity> mainActivityClass) {

        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;

            // Load clientId and redirectUrl from application manifest
            String clientId = bundle.getString("com.example.csulb.wecare.CLIENT_ID");
            String redirectUrl = bundle.getString("com.example.csulb.wecare.REDIRECT_URL");


            ClientCredentials CLIENT_CREDENTIALS = new ClientCredentials(clientId, CLIENT_SECRET, redirectUrl);

            return new AuthenticationConfigurationBuilder()

                    .setClientCredentials(CLIENT_CREDENTIALS)
                    .setEncryptionKey(SECURE_KEY)
                    .setTokenExpiresIn(2592000L) // 30 days
                    .setBeforeLoginActivity(new Intent(context, mainActivityClass))
                    .addRequiredScopes(Scope.profile, Scope.settings, Scope.activity, Scope.heartrate)
                    //.addOptionalScopes(activity, Scope.weight)
                    .setLogoutOnAuthFailure(true)

                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 1. When the application starts, load our keys and configure the AuthenticationManager
     */
    @Override
    public void onCreate() {
        super.onCreate();
        AuthenticationManager.configure(this, generateAuthenticationConfiguration(this, RootActivity.class));
    }
}
