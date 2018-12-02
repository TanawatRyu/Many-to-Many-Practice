/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.controller;

import com.guzap.CloudNative.User.User;
import com.guzap.CloudNative.User.UserService;
import java.util.HashMap;

import javax.validation.Valid;

import org.jboss.jandex.TypeTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wdrdr
 */
@RestController
public class RegisterController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register/ticket")
    public ResponseEntity<User> userPurchaseTicket(@Valid @RequestBody HashMap registerDetail){
        return new ResponseEntity<User>(userService.purchaseTicket(registerDetail), HttpStatus.CREATED);
    }
    
}
