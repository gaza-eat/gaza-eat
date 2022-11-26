package com.example.gazaeat.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public UserEntity signup(UserEntity user) {
        return userRepository.save(user);
    }

    public boolean login(UserEntity user) {
        UserEntity byAccountId = userRepository.findByAccountId(user.getAccountId());
        if(byAccountId.password.equals(user.getAccountId())){
            return true;
        }
        return false;
    }

}
