package com.example.noteTaker.controller;

import com.example.noteTaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


}
