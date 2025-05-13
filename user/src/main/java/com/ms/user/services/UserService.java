package com.ms.user.services;

import com.ms.user.exceptions.UserAlreadyExists;
import com.ms.user.models.User;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user){
        int userExists = userRepository.findByEmail(user.getEmail());
        if (userExists > 0) {
            throw new UserAlreadyExists("User already exists");
        }
        return userRepository.save(user);
    }


}
