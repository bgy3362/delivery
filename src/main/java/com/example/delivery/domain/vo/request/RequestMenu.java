package com.example.delivery.domain.vo.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequestMenu {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "Price cannot be null")
    private int price;
}
