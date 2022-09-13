package com.gabo.users.services;

import com.gabo.users.models.User;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Gabriel Galvan
 * Date:  08/09/2022
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private Faker faker;


    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {

            users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<User> getUser(String starWith) {
        if (starWith != null) {
            return users.stream().filter(u -> u.getUsername().toLowerCase().startsWith(starWith.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    public User getUserByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username))
        );
    }

    public User creteUser(User user) {
        if (users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(user.getUsername()))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s already exist", user.getUsername()));
        }
        users.add(user);
        return user;
    }

    public User updateUser(User user, String username) {
        LOGGER.info("Usuario {}", user);
        LOGGER.info("Username {}", username);
        User userToUpdate = getUserByUsername(username);
        userToUpdate.setNickname(user.getNickname());
        userToUpdate.setPassword(user.getPassword());
        return userToUpdate;

    }

    public void deleteUser(String username) {
        User userToDelete = getUserByUsername(username);
        users.remove(userToDelete);
    }

}
