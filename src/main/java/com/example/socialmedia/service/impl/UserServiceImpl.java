package com.example.socialmedia.service.impl;

import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepository();

    @Override
    public String registerUser(String userId, String username) {
        userRepository.addUser(userId, username);
        return username + " Registered!!";
    }
}
