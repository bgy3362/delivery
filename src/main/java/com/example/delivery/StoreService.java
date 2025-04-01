package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final OwnerService ownerService;

    @Transactional
    public StoreResponseDto createRest(Long id, StoreRequestDto storeRequestDto) {
        // 0. jwt Owner 확인
        Owner owner = ownerService.findById(id);

        StoreCategory category = StoreCategory.fromString(storeRequestDto.getCategory());

        Store store = Store.builder()
                .name(storeRequestDto.getName())
                .address(storeRequestDto.getAddress())
                .category(category)
                .owner(owner)
                .build();

        Store savedStore = storeRepository.save(store);

        return new StoreResponseDto(savedStore);
    }
}
