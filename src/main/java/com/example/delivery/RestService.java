package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestService {
    private final RestRepository restRepository;
    private final OwnerService ownerService;

    @Transactional
    public RestResponseDto createRest(Long id, RestRequestDto restRequestDto) {
        // 0. jwt Owner 확인
        Owner owner = ownerService.findById(id);

        RestCategory category = RestCategory.fromString(restRequestDto.getCategory());

        Rest rest = Rest.builder()
                .name(restRequestDto.getName())
                .address(restRequestDto.getAddress())
                .category(category)
                .owner(owner)
                .build();

        Rest savedRest = restRepository.save(rest);

        return new RestResponseDto(savedRest);
    }
}
