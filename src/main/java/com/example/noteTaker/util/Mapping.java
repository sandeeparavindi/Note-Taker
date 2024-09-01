package com.example.noteTaker.util;

import com.example.noteTaker.dto.NoteDTO;
import com.example.noteTaker.dto.UserDTO;
import com.example.noteTaker.entity.NoteEntity;
import com.example.noteTaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public NoteDTO convertToDTO(NoteEntity note){
        return modelMapper.map(note, NoteDTO.class);
    }

    public NoteEntity converToEntity(NoteDTO dto){
        return modelMapper.map(dto, NoteEntity.class);
    }

    public List<NoteDTO> converToDTO(List<NoteEntity> notes){
        return modelMapper.map(notes, List.class);
    }

    //User Matters mapping
    public UserDTO convertToUserDTO(UserEntity user){
        return modelMapper.map(user, UserDTO.class);
    }

    public UserEntity converToUserEntity(UserDTO dto){
        return modelMapper.map(dto, UserEntity.class);
    }

    public List<UserDTO> converToUserDTO(List<UserEntity>users){
        return modelMapper.map(users, List.class);
    }

}
