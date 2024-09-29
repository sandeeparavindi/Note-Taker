package com.example.noteTaker.dto.impl;

import com.example.noteTaker.customObj.UserResponse;
import com.example.noteTaker.dto.SuperDTO;
import com.example.noteTaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO implements UserResponse, SuperDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteEntity> notes;
}
