package code.domain.region;

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

import code.domain.food.FoodEntity;
import code.domain.foodregion.FoodRegionEntity;
import code.domain.user.UserEntity;
import lombok.Data;

@Entity
@Table(name = "region") @Data
public class RegionEntity 
{
    @Id @Column(name = "region_code")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Integer regionCode; // 지역코드
    @Column(name = "name")
    String name; // 이름
    @Column(name = "description")
    String description; // 설명

    @Column(name = "image_url")
    String imageUrl;

    @JoinColumn(name = "register_no")
    @ManyToOne
    UserEntity register;
}
