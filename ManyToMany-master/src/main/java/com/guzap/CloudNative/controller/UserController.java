/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.controller;

import com.guzap.CloudNative.User.User;
import com.guzap.CloudNative.User.UserService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author wdrdr
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return new ResponseEntity<String>(userService.getAllUsers().toString(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> createUser(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User : " + userId + " has been deleted !!!", HttpStatus.OK);
    }
    
    @PutMapping("/user")
    public ResponseEntity<User> updateUserById(@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUserById(user), HttpStatus.OK);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable long userId){
        return new ResponseEntity<User>(userService.findUserById(userId),HttpStatus.OK);
    }

}
