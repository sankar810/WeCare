package com.fitbit.api.services;

import android.app.Activity;
import android.content.Loader;

import com.fitbit.api.exceptions.MissingScopesException;
import com.fitbit.api.exceptions.TokenExpiredException;
import com.fitbit.api.loaders.ResourceLoaderFactory;
import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.Heart;
import com.fitbit.authentication.Scope;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sanka on 5/3/2018.
 */

//clas for loading heartrate scopes and url
public class HeartService {

    private final static String HEART_URL = "https://api.fitbit.com/1/user/-/activities/heart/date/today/1d.json";
    private static final ResourceLoaderFactory<Heart> HEART_LOADER_FACTORY = new ResourceLoaderFactory<>(HEART_URL, Heart.class);
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static Loader<ResourceLoaderResult<Heart>> getUserHeartLoader(Activity activityContext, Date date) throws MissingScopesException, TokenExpiredException {
        return HEART_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.heartrate}, dateFormat.format(date));
    }

}
