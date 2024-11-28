package com.example.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.socialmedia.service.InteractionService;

@RestController
@RequestMapping("/api/interaction")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @PostMapping("/user")
    public String interactWithUser(@RequestParam String type, @RequestParam String userId1, @RequestParam String userId2) {
        return interactionService.interactWithUser(type, userId1, userId2);
    }
}
