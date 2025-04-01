package com.example.delivery;

import java.util.Arrays;

public enum StoreCategory {
    KOREA, JAPAN, CHINA, WESTERN;

    public static StoreCategory fromString(String value) {
        return Arrays.stream(values())
                .filter(category -> category.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category: " + value));
    }
}
