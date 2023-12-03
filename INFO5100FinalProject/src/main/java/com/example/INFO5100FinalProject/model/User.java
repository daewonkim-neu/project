package com.example.INFO5100FinalProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Getter
@Setter
@ToString
public class User {

    @NonNull
    private final UUID id;
    @NonNull
    private final String name;
    @NonNull
    private final String userName;
    @NonNull
    private final String password;
    @NonNull
    private final String email;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("userName") String userName,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
