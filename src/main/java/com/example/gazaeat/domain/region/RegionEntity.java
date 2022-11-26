package com.example.gazaeat.domain.region;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Data @NoArgsConstructor
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

    public RegionEntity(Integer no)
    {
        id=no;
    }
}
