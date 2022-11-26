package com.example.gazaeat.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
@Entity@Data
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;
    String accountId;
    String password;
}