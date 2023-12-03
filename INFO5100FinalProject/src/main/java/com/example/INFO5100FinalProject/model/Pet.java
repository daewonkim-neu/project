package com.example.INFO5100FinalProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.UUID;

public class Pet {

    @NonNull
    private static UUID id;
    @NonNull
    private static String name;
    @NonNull
    private static String breed;
    @NonNull
    private static double weight;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private static Date dob;
    @NonNull
    private static String detail;
    @NonNull
    private static String userName;

    public Pet(@JsonProperty("id") UUID id,
               @JsonProperty("name") String name,
               @JsonProperty("breed") String breed,
               @JsonProperty("weight") Double weight,
               @JsonProperty("dob") Date dob,
               @JsonProperty("detail") String detail,
               @JsonProperty("userName") String userName) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.dob = dob;
        this.detail = detail;
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public double getWeight() {
        return weight;
    }
    public Date getDob() {
        return dob;
    }
    public String getDetail() {
        return detail;
    }
    public String getUserName() {
        return userName;
    }
}
