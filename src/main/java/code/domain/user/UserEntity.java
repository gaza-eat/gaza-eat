package code.domain.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import code.domain.food.FoodEntity;
import code.domain.region.RegionEntity;
import lombok.Data;

@Table(name="user")
@Entity @Data
public class UserEntity {


    @Id @Column(name = "user_no")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long userNo;
    
    @Column(unique = true)
    String id;
    String password;

}
