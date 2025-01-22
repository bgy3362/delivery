package com.example.delivery.domain.vo.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUserLogin {
    @NotNull(message = "userId cannot be null")
    @Size(min = 2, message = "userId not be less than two characters")
    private String userId;

    @NotNull(message = "Pwd cannot be null")
    @Size(min = 8, message = "Pwd not be less than eight characters")
    private String pwd;
}
