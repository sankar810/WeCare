package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanka on 5/3/2018.
 */

//heart class for heartrate keys
public class Heart {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("activitiesheart")
    @Expose
    private ActivitiesHeart activitiesheart;
    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * @return The summary
     */
    public ActivitiesHeart getActivitiesHeart() {
        return activitiesheart;
    }

    /**
     * @param activitiesheart The value
     */
    public void setActivitiesHeart(ActivitiesHeart activitiesheart) {
        this.activitiesheart= activitiesheart;
    }
}
