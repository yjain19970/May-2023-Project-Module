package com.scaler.firstspringproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class PingController {


    @GetMapping("") // /ping
    public String ping(){
        return "pong";
    }

    @GetMapping("/hello") // /ping/hello
    public String pingHello(){
        return "hello-pong";
    }
}


/**
 * 11:00 PM IST
 *
 */