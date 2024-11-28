package com.example.socialmedia.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private String postId;
    private String userId;
    private String content;
    private LocalDateTime timestamp;
    private int likes;
    private int dislikes;

    public Post(String userId, String content) {
        this.postId = UUID.randomUUID().toString();
        this.userId = userId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public void unlike() {
        if (likes > 0) likes--;
    }

    public void undislike() {
        if (dislikes > 0) dislikes--;
    }
}
