package code.domain.foodregion;

import javax.persistence.*;
import code.domain.food.FoodEntity;
import code.domain.region.RegionEntity;

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
