package code.domain.food;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.plaf.synth.Region;

import org.hibernate.annotations.ManyToAny;

import code.domain.foodregion.FoodRegionEntity;
import code.domain.region.RegionEntity;
import code.domain.user.UserEntity;
import lombok.Data;

@Entity
@Table(name="food") @Data
public class FoodEntity 
{   

    @Id @Column(name = "food_no")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long foodNo; // 음식 코드

    @Column(name="description")
    String description; // 음식 설명

    @Column(name="date")
    String date; // 날짜
    @Column(name="category")
    String category; // 카테고리

    @ManyToOne
    @JoinColumn(name="register_no")
    UserEntity register;

}
