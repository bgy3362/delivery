package com.example.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestResponseDto {
    private String name;
    private String address;
    private String category;

    public RestResponseDto(Rest rest) {
        this.name = rest.getName();
        this.address = rest.getAddress();
        this.category = rest.getCategory().name();
    }
}
