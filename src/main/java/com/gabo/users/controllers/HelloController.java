package com.gabo.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Gabriel Galvan
 * Date:  08/09/2022
 */
@RestController //*esterreotipo que es una meta anotacion que contiene controller y @ResponseBody
@RequestMapping("/hello")//* ruta de la api
public class HelloController {
    @GetMapping
    public  String hello(){
        return "! Hola mundo estoy aprendiendo spring!";
    }
}
