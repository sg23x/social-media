package com.example.socialmedia.repository;

import com.example.socialmedia.model.Post;
import java.util.*;

public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Post getPostById(String postId) {
        return posts.stream().filter(post -> post.getPostId().equals(postId)).findFirst().orElse(null);
    }
}
