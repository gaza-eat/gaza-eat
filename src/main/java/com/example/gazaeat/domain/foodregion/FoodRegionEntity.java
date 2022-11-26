package com.example.gazaeat.domain.foodregion;

import javax.persistence.*;
import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.region.RegionEntity;

public class FoodRegionEntity 
{
    @Id @Column(name="user_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long relationNo;

    @JoinColumn(name = "region_no")
    @ManyToOne(fetch = FetchType.EAGER)
    RegionEntity region;

    @JoinColumn(name = "food_no")
    @ManyToOne(fetch = FetchType.EAGER)
    FoodEntity food;

}
