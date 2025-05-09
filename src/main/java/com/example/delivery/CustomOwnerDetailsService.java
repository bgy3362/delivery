package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomOwnerDetailsService implements UserDetailsService {

    private final OwnerRepository ownerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String ownerId) throws UsernameNotFoundException {
        return ownerRepository.findByOwnerId(ownerId)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(ownerId + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(Owner owner) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(owner.getAuthority().toString());

        return new User(
                String.valueOf(owner.getId()),
                owner.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}