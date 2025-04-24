package com.example.delivery;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
@Entity
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private int table;
    private int eating;
    private int waiting;

    @Enumerated(EnumType.STRING)
    private StoreCategory category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
