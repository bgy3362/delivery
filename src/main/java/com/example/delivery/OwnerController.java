package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping("/me")
    public ResponseEntity<OwnerResponseDto> findOwnerInfoById() {
        return ResponseEntity.ok(ownerService.findOwnerInfoById(SecurityUtil.getCurrentId()));
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerResponseDto> findOwnerInfoByOwnerId(@PathVariable String ownerId) {
        return ResponseEntity.ok(ownerService.findOwnerInfoByOwnerId(ownerId));
    }
}