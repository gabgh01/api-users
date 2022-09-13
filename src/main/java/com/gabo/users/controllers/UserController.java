package com.gabo.users.controllers;

import com.gabo.users.models.User;
import com.gabo.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "startWith",required = false) String starWith) {
        return new ResponseEntity<>(userService.getUser(starWith), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        return new ResponseEntity<>(userService.creteUser(user), HttpStatus.CREATED);

    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<User> update(@PathVariable("username") String username, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user, username), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
        this.userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
