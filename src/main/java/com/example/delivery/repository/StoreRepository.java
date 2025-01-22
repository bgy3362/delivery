package com.example.delivery.repository;

import com.example.delivery.domain.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreEntity, Long>  {
}
