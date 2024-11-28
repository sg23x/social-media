package com.example.socialmedia.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userId;
    private String username;
    private Set<String> followers = new HashSet<>();
    private Set<String> following = new HashSet<>();

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void addFollower(String followerId) {
        this.followers.add(followerId);
    }

    public void removeFollower(String followerId) {
        this.followers.remove(followerId);
    }

    public void follow(String userId) {
        this.following.add(userId);
    }

    public void unfollow(String userId) {
        this.following.remove(userId);
    }
}
