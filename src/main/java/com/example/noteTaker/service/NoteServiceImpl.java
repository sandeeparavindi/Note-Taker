package com.example.noteTaker.service;

import com.example.noteTaker.dao.NoteDAO;
import com.example.noteTaker.dto.impl.NoteDTO;
import com.example.noteTaker.entity.NoteEntity;
import com.example.noteTaker.exception.NoteNotFound;
import com.example.noteTaker.util.AppUtil;
import com.example.noteTaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional// Component annotation eka meta anotate krla thinne service annotation eka athule
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.converToEntity(noteDTO);
        noteDAO.save(noteEntity);
        return "Saved successfully in Service layer";
    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {
        Optional<NoteEntity> tmpNoteEntity= noteDAO.findById(noteId);
        if(!tmpNoteEntity.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            tmpNoteEntity.get().setNoteDesc(incomeNoteDTO.getNoteDesc());
            tmpNoteEntity.get().setNoteTitle(incomeNoteDTO.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(incomeNoteDTO.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(incomeNoteDTO.getPriorityLevel());
        }
    }

    @Override
    public boolean deleteNote(String noteId) {
        if (noteDAO.existsById(noteId)){
            noteDAO.deleteById(noteId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        return mapping.convertToDTO(noteDAO.getReferenceById(noteId));
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mapping.converToDTO(noteDAO.findAll());
    }
}
