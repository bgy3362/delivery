package com.example.delivery.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "owner")
public class OwnerEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "owner_uuid", nullable = false, unique = true)
    private String ownerId;

    @Column(nullable = false) // unique 로 변경
    private String encryptedPwd;
}
