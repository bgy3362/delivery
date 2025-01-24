package com.example.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponseDto {
    private String name;
    private String email;
    private String ownerId;
    public static OwnerResponseDto of(Owner owner) {
        return new OwnerResponseDto(owner.getName(),
                                    owner.getEmail(),
                                    owner.getOwnerId());
    }
}