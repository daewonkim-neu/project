package com.example.INFO5100FinalProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Appointment {

    @NonNull
    private final UUID id;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private final Date time;
    @NonNull
    private final String service;
    @NonNull
    private final String petName;
    @NonNull
    private final String detail;

    public Appointment(@JsonProperty("id") UUID id,
                       @JsonProperty("time") Date time,
                       @JsonProperty("service") String service,
                       @JsonProperty("petName") String petName,
                       @JsonProperty("detail") String detail) {
        this.id = id;
        this.time = time;
        this.service = service;
        this.petName = petName;
        this.detail = detail;
    }
}
