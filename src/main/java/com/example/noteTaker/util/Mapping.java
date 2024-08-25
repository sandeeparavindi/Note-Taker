package com.example.noteTaker.util;

import com.example.noteTaker.dto.NoteDTO;
import com.example.noteTaker.entity.NoteEntity;
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
}
