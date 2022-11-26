package com.example.gazaeat.domain.food;
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

import com.example.gazaeat.domain.user.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

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
