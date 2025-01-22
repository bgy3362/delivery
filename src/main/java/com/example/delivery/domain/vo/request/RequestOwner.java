package com.example.delivery.domain.vo.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequestOwner {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    private String email;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "Pwd cannot be null")
    @Size(min = 8, message = "Pwd not be less than eight characters")
    private String pwd;

    //연락처
}
