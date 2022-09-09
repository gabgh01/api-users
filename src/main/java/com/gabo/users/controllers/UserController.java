package com.gabo.users.controllers;

import com.gabo.users.models.User;
import com.gabo.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Gabriel Galvan
 * Date:  08/09/2022
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //* @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    //** Handler method
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getUser(), HttpStatus.OK);
    }
}
