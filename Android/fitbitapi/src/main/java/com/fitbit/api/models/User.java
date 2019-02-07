package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//keys for user class
public class User {

    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("averageDailySteps")
    @Expose
    private Integer averageDailySteps;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("gender")
    @Expose
    private String gender;
    /**
     * @return The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * @return The averageDailySteps
     */
    public Integer getAverageDailySteps() {
        return averageDailySteps;
    }

    /**
     * @param averageDailySteps The averageDailySteps
     */
    public void setAverageDailySteps(Integer averageDailySteps) {
        this.averageDailySteps = averageDailySteps;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
