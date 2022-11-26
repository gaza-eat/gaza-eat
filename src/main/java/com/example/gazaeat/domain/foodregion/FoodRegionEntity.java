package com.example.gazaeat.domain.foodregion;

import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.region.RegionEntity;
import lombok.Data;
import javax.persistence.*;
import lombok.Data;

@Entity@Data
@Table(name = "food_region")
public class FoodRegionEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long relationNo;

    @JoinColumn(name = "food_no")
    @ManyToOne
    FoodEntity food;

    @JoinColumn(name="region_no")
    @ManyToOne
    RegionEntity region;
}
