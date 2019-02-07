package com.fitbit.authentication;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by sanka on 5/3/2018.
 */
//client credentials class
public class ClientCredentials implements Parcelable {
    public static final Creator<ClientCredentials> CREATOR = new Creator<ClientCredentials>() {
        @Override
        public ClientCredentials createFromParcel(Parcel in) {
            return new ClientCredentials(in);
        }

        @Override
        public ClientCredentials[] newArray(int size) {
            return new ClientCredentials[size];
        }
    };
    private String clientId;
    private String clientSecret;
    private String redirectUrl;

    //constructor
    public ClientCredentials(String clientId, String clientSecret, String redirectUrl) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }

    //constructor
    protected ClientCredentials(Parcel in) {
        clientId = in.readString();
        clientSecret = in.readString();
        redirectUrl = in.readString();
    }

    //return client id
    public String getClientId() {
        return clientId;
    }

    //assign client id
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    //return client secret id
    public String getClientSecret() {
        return clientSecret;
    }

    //assign client secret id
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    //return redirect url
    public String getRedirectUrl() {
        return redirectUrl;
    }

    //assignredirect url
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    //check wither id's are complete and return
    public boolean isComplete() {
        return !TextUtils.isEmpty(clientId)
                && !TextUtils.isEmpty(clientSecret)
                && !TextUtils.isEmpty(redirectUrl);
    }

    //describe contents
    @Override
    public int describeContents() {
        return 0;
    }

    //write ocntents
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(clientId);
        parcel.writeString(clientSecret);
        parcel.writeString(redirectUrl);
    }
}
