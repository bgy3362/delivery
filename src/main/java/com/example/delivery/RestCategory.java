package com.example.delivery;

import java.util.Arrays;

public enum RestCategory {
    KOREA, JAPAN, CHINA, WESTERN;

    public static RestCategory fromString(String value) {
        return Arrays.stream(values())
                .filter(category -> category.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category: " + value));
    }
}
