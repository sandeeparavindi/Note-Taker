package com.example.noteTaker.service;

import com.example.noteTaker.customObj.UserErrorResponse;
import com.example.noteTaker.customObj.UserResponse;
import com.example.noteTaker.dao.UserDAO;
import com.example.noteTaker.dto.impl.UserDTO;
import com.example.noteTaker.entity.UserEntity;
import com.example.noteTaker.exception.UserNotFoundException;
import com.example.noteTaker.util.AppUtil;
import com.example.noteTaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDAO userDAO;

    @Autowired
    private final Mapping mapping;
    @Override
    public String saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity savedUser =
                userDAO.save(mapping.converToUserEntity(userDTO));
        if(savedUser != null && savedUser.getUserId() != null ) {
            return "User saved successfully";
        }else {
            return "Save failed";
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDAO.findById(userDTO.getUserId());
        if (!tmpUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        } else {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUserId = userDAO.findById(userId);
        if(!selectedUserId.isPresent()){
            throw new UserNotFoundException("User not found");
        }else {
            userDAO.deleteById(userId);
        }
    }

    @Override
    public UserResponse getSelectedUser(String userId) {
        if(userDAO.existsById(userId)){
            UserEntity userEntityByUserId = userDAO.getUserEntityByUserId(userId);
            return mapping.convertToUserDTO(userEntityByUserId);
        }else {
            return new UserErrorResponse(0, "User not found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> getAllUsers = userDAO.findAll();
        return mapping.convertUserToDTOList(getAllUsers);
    }
}
