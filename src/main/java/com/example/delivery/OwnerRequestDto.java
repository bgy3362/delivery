package com.example.delivery;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequestDto {

    private String name;
    private String email;
    private String ownerId;
    private String password;

    public Owner toOwner(PasswordEncoder passwordEncoder) {
        return Owner.builder()
                .name(name)
                .email(email)
                .ownerId(ownerId)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_OWNER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(ownerId, password);
    }
}