package com.example.delivery.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId; // UUID 기반
    private Date createdAt;

    private String encryptedPwd; // RequestUser pwd 기반
}
