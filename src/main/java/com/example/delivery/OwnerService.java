package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerResponseDto findOwnerInfoById(Long id) {
        return ownerRepository.findById(id)
                .map(OwnerResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public OwnerResponseDto findOwnerInfoByOwnerId(String ownerId) {
        return ownerRepository.findByOwnerId(ownerId)
                .map(OwnerResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }
}