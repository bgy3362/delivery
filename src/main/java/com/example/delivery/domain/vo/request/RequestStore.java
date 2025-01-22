package com.example.delivery.domain.vo.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequestStore {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "businessRegisterNumber cannot be null")
    @Size(min = 10, message = "businessRegisterNumber not be less than ten characters")
    private String businessRegisterNumber;
}
