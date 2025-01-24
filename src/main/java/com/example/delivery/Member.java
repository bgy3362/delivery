package com.example.delivery;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "member_private_id", unique = true)
    private String memberId;
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String name, String email, String memberId, String password, Authority authority) {
        this.name = name;
        this.email = email;
        this.memberId = memberId;
        this.password = password;
        this.authority = authority;
    }
}
