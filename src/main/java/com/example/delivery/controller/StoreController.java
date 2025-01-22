package com.example.delivery.controller;

import com.example.delivery.domain.dto.OwnerDto;
import com.example.delivery.domain.dto.StoreDto;
import com.example.delivery.domain.vo.request.RequestOwner;
import com.example.delivery.domain.vo.request.RequestStore;
import com.example.delivery.domain.vo.response.ResponseOwner;
import com.example.delivery.domain.vo.response.ResponseStore;
import com.example.delivery.service.OwnerService;
import com.example.delivery.service.StoreService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StoreController {
    private StoreService storeService;
    @PostMapping("/stores")
    public ResponseEntity createStore(@RequestBody RequestStore store) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StoreDto storeDto = mapper.map(store, StoreDto.class);


        storeService.createStore(storeDto);
        ResponseStore responseStore = mapper.map(storeDto, ResponseStore.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStore);
    }
}
