package com.example.delivery.controller;

import com.example.delivery.domain.dto.OwnerDto;
import com.example.delivery.domain.dto.UserDto;
import com.example.delivery.domain.vo.request.RequestOwner;
import com.example.delivery.domain.vo.request.RequestUser;
import com.example.delivery.domain.vo.response.ResponseOwner;
import com.example.delivery.domain.vo.response.ResponseUser;
import com.example.delivery.service.OwnerService;
import com.example.delivery.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/owners")
    public ResponseEntity createOwner(@RequestBody RequestOwner owner) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OwnerDto ownerDto = mapper.map(owner, OwnerDto.class);


        ownerService.createOwner(ownerDto);
        ResponseOwner responseOwner = mapper.map(ownerDto, ResponseOwner.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseOwner);
    }
}
