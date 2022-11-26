package com.example.gazaeat.domain.food;

import com.example.gazaeat.domain.user.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="food")
@Data @Entity @NoArgsConstructor
public class FoodEntity 
{   

    @Id @Column(name = "food_no")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long foodNo; // 음식 코드

    String name;

    @Column(name="description")
    String description; // 음식 설명

    @ManyToOne
    @JoinColumn(name="register_no")
    UserEntity register;

    public FoodEntity(Long no)
    {
        foodNo = no;
    }

}
