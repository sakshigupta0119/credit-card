package com.project.credit.card.controller;

import com.project.credit.card.Entities.Users;
import com.project.credit.card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
@Autowired
    private UserService userService;

//    @GetMapping("/{userId}")
//    public Users getUserById(@PathVariable long userId)
//    {
//        try {
//            return this.userService.getUserById(userId);
//        } catch (RecordNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @GetMapping("/resp/{userId}")
//    public ResponseEntity<Object> getUserByIdResponse(@PathVariable long userId)
//    {
//        try {
//            Users user = this.userService.getUserById(userId);
//            return ResponseEntity.status(HttpStatus.FOUND).body(user);
//        } catch (RecordNotFoundException e) {
//            return ResponseEntity.noContent().build();
//        }
//    }
@GetMapping("/gender/{gender}")
public List<Users> getTransactionsByGender(@PathVariable String gender){
    List<Users> temp = this.userService.getTransactionsByGender(gender);
    System.out.println(temp);
    return temp;
}
}
