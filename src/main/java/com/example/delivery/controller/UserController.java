package com.example.delivery.controller;

import com.example.delivery.domain.dto.UserDto;
import com.example.delivery.domain.vo.request.RequestUser;
import com.example.delivery.domain.vo.request.RequestUserLogin;
import com.example.delivery.domain.vo.response.ResponseUser;
import com.example.delivery.security.JwtTokenProvider;
import com.example.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/health_check")
    public String status() {
        return "hello";
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Validated @RequestBody RequestUser requestUser) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(requestUser, UserDto.class);

        userService.createUser(userDto);
        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Validated @RequestBody RequestUserLogin requestUserLogin) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(requestUserLogin, UserDto.class);
        userService.login(userDto);

        String token = jwtTokenProvider.generateToken(requestUserLogin.getUserId());
        return ResponseEntity.ok(token);
    }
}
