package com.example.gazaeat.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
@Entity@Data @NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;
    String accountId;
    String password;

    public UserEntity(Long no)
    {
        id = no;
    }

}
