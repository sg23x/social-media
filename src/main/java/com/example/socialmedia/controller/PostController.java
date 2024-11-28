package com.example.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.socialmedia.service.PostService;
import com.example.socialmedia.model.Post;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/upload")
    public String uploadPost(@RequestParam String userId, @RequestParam String content) {
        return postService.uploadPost(userId, content);
    }

    @GetMapping("/feed")
    public List<Post> getFeed(@RequestParam String userId) {
        return postService.getFeed(userId);
    }

    @PostMapping("/like")
    public String likePost(@RequestParam String userId, @RequestParam String postId) {
        return postService.likePost(userId, postId);
    }

    @PostMapping("/dislike")
    public String dislikePost(@RequestParam String userId, @RequestParam String postId) {
        return postService.dislikePost(userId, postId);
    }
}
