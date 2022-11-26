package com.example.gazaeat.domain.region;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.gazaeat.domain.foodregion.FoodRegionEntity;
import lombok.Data;

@Entity
@Table(name = "region") @Data
public class RegionEntity 
{
    @Id @Column(name = "region_code")
    Integer regionCode; // 지역코드
    @Column(name = "name")
    String name; // 이름
    @Column(name = "description")
    String description; // 설명

    @Column(name = "image_url")
    String imageUrl;

    @JoinColumn()
    List<FoodRegionEntity> foods; // 이 지역의 음식
}
