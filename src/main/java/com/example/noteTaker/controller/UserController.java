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

import java.util.List;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") String userId) {
        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("id") String userId){
        return userService.getSelectedUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateUser(
            @PathVariable ("id") String id,
            @RequestPart("updateFirstName") String updateFirstName,
            @RequestPart ("updateLastName") String updateLastName,
            @RequestPart ("updateEmail") String updateEmail,
            @RequestPart ("updatePassword") String updatePassword,
            @RequestPart ("updateProfilePic") String updateProfilePic
    ){
        String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateProfilePic);
        var updateUser = new UserDTO();
        updateUser.setUserId(id);
        updateUser.setFirstName(updateFirstName);
        updateUser.setLastName(updateLastName);
        updateUser.setPassword(updatePassword);
        updateUser.setEmail(updateEmail);
        updateUser.setProfilePic(updateBase64ProfilePic);
        return userService.updateUser(updateUser)? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
