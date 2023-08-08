package com.jwt.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/health")
   public String health(){
return "This is a secured Api";
    }
}
