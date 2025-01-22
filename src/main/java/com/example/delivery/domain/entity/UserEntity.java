package com.example.delivery.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "user_private_id", nullable = false, unique = true)
    private String userId;

    @Column(nullable = false) // unique 로 변경
    private String encryptedPwd;
}
