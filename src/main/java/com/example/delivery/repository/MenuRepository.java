package com.example.delivery.repository;

import com.example.delivery.domain.entity.MenuEntity;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<MenuEntity, Long> {
}
