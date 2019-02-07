package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//summary class for summary keys
public class Summary {

    @SerializedName("caloriesOut")
    @Expose
    private Integer caloriesOut;
    @SerializedName("steps")
    @Expose
    private Integer steps;
    @SerializedName("fairlyActiveMinutes")
    @Expose
    private Integer fairlyActiveMinutes;


    /**
     * @return The caloriesOut
     */
    public Integer getCaloriesOut() {
        return caloriesOut;
    }

    /**
     * @param caloriesOut The caloriesOut
     */
    public void setCaloriesOut(Integer caloriesOut) {
        this.caloriesOut = caloriesOut;
    }


    /**
     * @return The steps
     */
    public Integer getSteps() {
        return steps;
    }

    /**
     * @param steps The steps
     */
    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    /**
     * @return The fairlyActiveMinutes
     */
    public Integer getFairlyActiveMinutes() {
        return fairlyActiveMinutes;
    }

    /**
     * @param fairlyActiveMinutes The fairlyActiveMinutes
     */
    public void setFairlyActiveMinutes(Integer fairlyActiveMinutes) {
        this.fairlyActiveMinutes = fairlyActiveMinutes;
    }
}