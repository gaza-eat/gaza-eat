package com.example.gazaeat.domain.foodregion;

import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.region.RegionEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "food_region")
@Data
public class FoodRegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long relationNo;

    @JoinColumn(name = "region_no")
    @ManyToOne(fetch = FetchType.EAGER)
    RegionEntity region;

    @JoinColumn(name = "food_no")
    @ManyToOne(fetch = FetchType.EAGER)
    FoodEntity food;
}
