package com.example.noteTaker.controller;

import com.example.noteTaker.dto.UserDTO;
import com.example.noteTaker.service.UserService;
import com.example.noteTaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") String profilePic) {

        //Handle profile picture
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
        var buildUserDto = new UserDTO();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(base64ProfilePic);

        return  new ResponseEntity<>(userService.saveUser(buildUserDto), HttpStatus.CREATED);
    }

}
