package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/create")
    public ResponseEntity<StoreResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto) {
        Long id = SecurityUtil.getCurrentId();
        return ResponseEntity.ok(storeService.createRest(id, storeRequestDto));
    }
}
