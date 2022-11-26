package com.example.gazaeat.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> 
{
    UserEntity findByAccountId(String accountId);
}
