package com.example.socialmedia.repository;

import com.example.socialmedia.model.User;
import java.util.*;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void addUser(String userId, String username) {
        users.put(userId, new User(userId, username));
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
