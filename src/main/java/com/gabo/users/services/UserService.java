package com.gabo.users.services;

import com.gabo.users.models.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Gabriel Galvan
 * Date:  08/09/2022
 */
@Service
public class UserService {
    @Autowired
    private Faker faker;


    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {

            users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }
    public List<User> getUser(){
        return users;
    }

    public User getUserByUsername(String username){
      return   users.stream().filter(u->u.getUsername().equalsIgnoreCase(username)).findAny().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("User %s not found",username))
        );
    }

}
