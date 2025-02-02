package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest")
public class RestController {
    private final RestService restService;

    @PostMapping("/create")
    public ResponseEntity<RestResponseDto> createRest(@RequestBody RestRequestDto restRequestDto) {
        Long id = SecurityUtil.getCurrentId();
        return ResponseEntity.ok(restService.createRest(id, restRequestDto));
    }
}
