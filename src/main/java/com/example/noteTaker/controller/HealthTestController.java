package com.example.noteTaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/healthCheck")
public class HealthTestController {
    @GetMapping
    public String healthCheck(){
        return "Note Tacker is Running...";
    }
}
