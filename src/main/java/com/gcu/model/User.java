package com.gcu.model;

import jakarta.validation.constraints.*;

public class User {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // getters and setters
}