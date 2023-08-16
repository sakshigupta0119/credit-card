package com.project.credit.card.controller;

import com.project.credit.card.Entities.Users;
import com.project.credit.card.exception.RecordNotFoundException;
import com.project.credit.card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {
@Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable long userId)
    {
        try {
            return this.userService.getUserById(userId);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/resp/{userId}")
    public ResponseEntity<Object> getUserByIdResponse(@PathVariable long userId)
    {
        try {
            Users user = this.userService.getUserById(userId);
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }



}
