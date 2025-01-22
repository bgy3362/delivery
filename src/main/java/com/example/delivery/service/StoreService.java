package com.example.delivery.service;

import com.example.delivery.domain.dto.OwnerDto;
import com.example.delivery.domain.dto.StoreDto;

public interface StoreService {
    StoreDto createStore(StoreDto storeDto);
}
