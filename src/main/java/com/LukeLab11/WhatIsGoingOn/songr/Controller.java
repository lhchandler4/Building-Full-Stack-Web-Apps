package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello, world! I hope I can begin to understand Spring!";
    }


}
