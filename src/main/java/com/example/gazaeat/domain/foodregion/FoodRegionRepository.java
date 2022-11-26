package com.example.gazaeat.domain.foodregion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRegionRepository extends JpaRepository<FoodRegionEntity, Long>
{
    //List<FoodRegionEntity> findAllByRegion_Region_no(Long regionNo);
    //List<FoodRegionEntity> findAllByFood_no(Long foodNo);
}
