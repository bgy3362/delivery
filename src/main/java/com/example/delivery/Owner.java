package com.example.delivery;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "owner")
@Entity
public class Owner {

    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "owner_private_id", unique = true, nullable = false)
    private String ownerId;
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "owner")
    private List<Rest> restaurants = new ArrayList<>();

    @Builder
    public Owner(String name, String email, String ownerId, String password, Authority authority) {
        this.name = name;
        this.email = email;
        this.ownerId = ownerId;
        this.password = password;
        this.authority = authority;
    }
}
