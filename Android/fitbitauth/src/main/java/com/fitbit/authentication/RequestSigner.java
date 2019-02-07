package com.fitbit.authentication;

import com.fitbit.fitbitcommon.network.BasicHttpRequestBuilder;

/**
 * Created by sanka on 4/8/2018.
 */

//interface for request signer
public interface RequestSigner {

    void signRequest(BasicHttpRequestBuilder builder);

}
