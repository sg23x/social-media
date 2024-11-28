package com.example.socialmedia.service.impl;

import com.example.socialmedia.model.User;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.InteractionService;
import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl implements InteractionService {

    private UserRepository userRepository = new UserRepository();

    @Override
    public String interactWithUser(String type, String userId1, String userId2) {
        User user1 = userRepository.getUser(userId1);
        User user2 = userRepository.getUser(userId2);

        if (user1 == null || user2 == null) {
            return "User(s) not found!";
        }

        if (type.equalsIgnoreCase("FOLLOW")) {
            user1.follow(userId2);
            user2.addFollower(userId1);
            return "Followed " + user2.getUsername() + "!!";
        } else if (type.equalsIgnoreCase("UNFOLLOW")) {
            user1.unfollow(userId2);
            user2.removeFollower(userId1);
            return "Unfollowed " + user2.getUsername() + "!!";
        }
        return "Invalid interaction type";
    }
}
