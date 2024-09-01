package com.example.noteTaker.controller;

import com.example.noteTaker.service.NoteService;
import com.example.noteTaker.dto.NoteDTO;
import com.example.noteTaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/note")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private NoteService noteService;

    //crud
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note) {
        var saveData = noteService.saveNote(note);
        return ResponseEntity.ok(saveData);
    }

    @GetMapping(value = "allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {
        System.out.println(noteId);
        return noteService.getSelectedNote(noteId);
    }

    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {
        return noteService.updateNote(noteId,note) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value ="/{noteId}" )
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
        return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
