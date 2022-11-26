package com.example.gazaeat.domain.foodregion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRegionRepository extends JpaRepository<FoodRegionEntity, Long>
{
    //List<FoodRegionEntity> findAllByRegion_Region_no(Long regionNo);
    //List<FoodRegionEntity> findAllByFood_no(Long foodNo);

    @Query(value="SELECT * FROM food_region WHERE food_no=:no", nativeQuery=true)
    List<FoodRegionEntity> findByFoodName(@Param("no") Long no);
}
