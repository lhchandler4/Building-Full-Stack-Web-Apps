package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello, world! The Gecko Becomes Godzilla!";
    }

    @GetMapping("/capitalize/{phrase}")
    public String capitalizeMe(@PathVariable String phrase) {
        return phrase.toUpperCase();
    }

    @GetMapping("/reverse")
    public String reverseMe(@RequestParam String sentence) {
        String[] words = sentence.split(" ");
        String outputString = "";
        for (int i = words.length-1; i >= 0; i--)
        {
            outputString = outputString + words[i] + " ";
        } return outputString;
        //or
//        StringBuilder sb = new StringBuilder();
//        for(int i = words.length -1; i >= 0; i--){
//            sb.append(words[i]);
//            sb.append(" ");
//        }
//        return sb.toString();
    }

}
