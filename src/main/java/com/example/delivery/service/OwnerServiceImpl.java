package com.example.delivery.service;

import com.example.delivery.domain.dto.OwnerDto;
import com.example.delivery.domain.dto.UserDto;
import com.example.delivery.domain.entity.OwnerEntity;
import com.example.delivery.domain.entity.UserEntity;
import com.example.delivery.repository.OwnerRepository;
import com.example.delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    OwnerRepository ownerRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        ownerDto.setOwnerId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OwnerEntity ownerEntity = mapper.map(ownerDto, OwnerEntity.class);
        ownerEntity.setEncryptedPwd(passwordEncoder.encode(ownerDto.getPwd())); // 패스워드 같아도 다른 값으로 해싱

        ownerRepository.save(ownerEntity);
        OwnerDto returnOwnerDto = mapper.map(ownerEntity, OwnerDto.class);

        return returnOwnerDto;
    }
}
