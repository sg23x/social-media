package com.example.socialmedia.service.impl;

import com.example.socialmedia.model.Post;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.PostService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository = new PostRepository();
    private UserRepository userRepository = new UserRepository();

    @Override
    public String uploadPost(String userId, String content) {
        if (userRepository.getUser(userId) == null) {
            return "User not found!";
        }
        Post post = new Post(userId, content);
        postRepository.addPost(post);
        return "Upload Successful with post id: " + post.getPostId();
    }

    @Override
    public List<Post> getFeed(String userId) {
        if (userRepository.getUser(userId) == null) {
            return Collections.emptyList();
        }
        Set<String> followedUsers = userRepository.getUser(userId).getFollowing();
        return postRepository.getPosts().stream()
                .sorted(Comparator.comparing(Post::getTimestamp).reversed())
                .filter(post -> followedUsers.contains(post.getUserId()) || post.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public String likePost(String userId, String postId) {
        Post post = postRepository.getPostById(postId);
        if (post == null) {
            return "Post not found!";
        }
        post.like();
        return "Post liked!";
    }

    @Override
    public String dislikePost(String userId, String postId) {
        Post post = postRepository.getPostById(postId);
        if (post == null) {
            return "Post not found!";
        }
        post.dislike();
        return "Post disliked!";
    }
}
