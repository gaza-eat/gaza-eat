package com.example.gazaeat.domain.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    FoodEntity findByName(String name);
}
