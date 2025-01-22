package com.example.delivery.service;

import com.example.delivery.domain.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    void login(UserDto userDto);
}
