package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
