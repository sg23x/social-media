package com.example.socialmedia.service;

import com.example.socialmedia.model.Post;
import java.util.List;

public interface PostService {
    String uploadPost(String userId, String content);
    List<Post> getFeed(String userId);
    String likePost(String userId, String postId);
    String dislikePost(String userId, String postId);
}
