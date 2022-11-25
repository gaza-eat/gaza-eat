package code.domain.food;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.plaf.synth.Region;

import code.domain.region.RegionEntity;
import code.domain.user.UserEntity;
import lombok.Data;

@Table(name="food") @Data
public class FoodEntity 
{   

    @Id @Column(name = "food_no")
    Long foodNo; // 음식 코드

    @Column(name="description")
    String description; // 음식 설명

    @Column(name="date")
    String date; // 날짜
    @Column(name="category")
    String category; // 카테고리

    
    UserEntity register; // 등록자
}
