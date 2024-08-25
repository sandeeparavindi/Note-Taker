package com.example.noteTaker.service;

import com.example.noteTaker.dto.NoteDTO;
import com.example.noteTaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service // Component annotation eka meta anotate krla thinne service annotation eka athule
public final class NoteServiceImpl implements NoteService {
    List<NoteDTO> saveNoteTm = new ArrayList<>();
    public NoteServiceImpl(){
        saveNoteTm.add(new NoteDTO("NOTE 4f8a0a67-2ebc-41b2-9de6-4e9bcdba65bb",
                "MadolDuwa","hiud","second","2024-08-25"));
        saveNoteTm.add(new NoteDTO("NOTE-4f8a0a67-2ebc-41b2-9de6-4e9bcdba66bb",
                "MadolDuwa","hiud","second","2024-08-25"));
        saveNoteTm.add(new NoteDTO("NOTE-4f8a0a67-2ebc-41b2-9de6-4e9bcdba67bb",
                "MadolDuwa","hiud","second","2024-08-25"));
        saveNoteTm.add(new NoteDTO("NOTE-4f8a0a67-2ebc-41b2-9de6-4e9bcdba68bb",
                "MadolDuwa","hiud","second","2024-08-25"));
        saveNoteTm.add(new NoteDTO("NOTE-4f8a0a67-2ebc-41b2-9de6-4e9bcdba69bb",
                "MadolDuwa","hiud","second","2024-08-25"));
        System.out.println(saveNoteTm);
    }
    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNote());
        saveNoteTm.add(noteDTO);
        return "Saved successfully in service layer";
    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {
        ListIterator<NoteDTO> updatedList = saveNoteTm.listIterator();
        while (updatedList.hasNext()) {
            NoteDTO noteDTO = updatedList.next();
            if (noteId.equals(noteDTO.getNoteId())) {
                incomeNoteDTO.setNoteId(noteDTO.getNoteId());
                updatedList.set(incomeNoteDTO);
                break;
            }
        }
    }

    @Override
    public void deleteNote(String noteId) {
        ListIterator<NoteDTO> tmList = saveNoteTm.listIterator();
        while (tmList.hasNext()){
            NoteDTO noteDTO = tmList.next();
            if (noteId.equals(noteDTO.getNoteId())){
                tmList.remove();
            }
        }
    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
        for (NoteDTO noteDTO : saveNoteTm){
            if (noteDTO.getNoteId().equals(noteId)){
                return noteDTO;
            }
        }
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return saveNoteTm;
    }
}
