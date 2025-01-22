package com.example.delivery.security;

import com.example.delivery.domain.entity.UserEntity;
import com.example.delivery.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userId: " + username));

        return User.builder()
                .username(userEntity.getUserId())
                .password(userEntity.getEncryptedPwd()) // 비밀번호는 반드시 암호화된 상태로 저장되어 있어야 함
                .roles("USER") // 필요에 따라 사용자 역할 설정
                .build();
    }
}
