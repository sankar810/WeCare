package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanka on 5/9/2018.
 */

//activity heart for displaying heartrate
public class ActivitiesHeart {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("value")
    @Expose
    private Value value;
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
    public Value getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(Value value) {
        this.value = value;
    }
}
