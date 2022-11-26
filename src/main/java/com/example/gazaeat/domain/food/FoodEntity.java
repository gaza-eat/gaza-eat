package com.example.gazaeat.domain.food;

import com.example.gazaeat.domain.user.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="food")
@Data
@Entity
public class FoodEntity 
{   

    @Id @Column(name = "food_no")
    Long foodNo; // 음식 코드

    String name;

    @Column(name="description")
    String description; // 음식 설명

    @Column(name="date")
    LocalDateTime date; // 날짜

    @Column(name="category")
    String category; // 카테고리

    @ManyToOne
    UserEntity register; // 등록자
}
