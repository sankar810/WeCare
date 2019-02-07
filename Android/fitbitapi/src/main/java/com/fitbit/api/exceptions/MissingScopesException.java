package com.fitbit.api.exceptions;

import com.fitbit.authentication.Scope;

import java.util.Collection;

/**
 * Created by sanka on 4/58/2018.
 */

//hadles missing scopes exception for each api
public class MissingScopesException extends FitbitAPIException {

    private Collection<Scope> scopes;

    public MissingScopesException(Collection<Scope> scopes) {
        this.scopes = scopes;
    }

    public Collection<Scope> getScopes() {
        return scopes;
    }
}
