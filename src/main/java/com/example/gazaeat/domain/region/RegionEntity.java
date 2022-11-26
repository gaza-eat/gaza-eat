package com.example.gazaeat.domain.region;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Data
public class RegionEntity {
    @Id
    @GeneratedValue
    Integer id; // 지역코드
    @Column(name = "name")
    String name; // 이름
    @Column(name = "description")
    String description; // 설명

    @Column(name = "image_url")
    String imageUrl;
}
