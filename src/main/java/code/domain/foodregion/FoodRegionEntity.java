package code.domain.foodregion;

import javax.persistence.*;
import code.domain.food.FoodEntity;
import code.domain.region.RegionEntity;
import lombok.Data;

@Entity @Table(name="food_region") @Data
public class FoodRegionEntity 
{
    @Id @Column(name="relation_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long relationNo;

    @JoinColumn(name = "food_no")
    @ManyToOne
    FoodEntity food;

    @JoinColumn(name="region_no")
    @ManyToOne
    RegionEntity region;

}
