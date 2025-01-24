package com.example.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByOwnerId(String ownerId);
    boolean existsByOwnerId(String ownerId);
}
