package com.example.delivery.repository;

import com.example.delivery.domain.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {
}
