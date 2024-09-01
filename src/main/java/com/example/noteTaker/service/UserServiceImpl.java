package com.example.noteTaker.service;

import com.example.noteTaker.dao.UserDAO;
import com.example.noteTaker.dto.UserDTO;
import com.example.noteTaker.util.AppUtil;
import com.example.noteTaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        userDAO.save(mapping.converToUserEntity(userDTO));
        return "User Saved Successfully";
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }
}
