package com.example.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponseDto {
    private String name;
    private String address;
    private String category;

    public StoreResponseDto(Store store) {
        this.name = store.getName();
        this.address = store.getAddress();
        this.category = store.getCategory().name();
    }
}
