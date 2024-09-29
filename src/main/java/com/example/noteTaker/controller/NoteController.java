package com.example.noteTaker.controller;

import com.example.noteTaker.exception.NoteNotFound;
import com.example.noteTaker.service.NoteService;
import com.example.noteTaker.dto.impl.NoteDTO;
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
    //Todo: SAVE a note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){
        //Todo: Handle with BO
        var saveData = noteService.saveNote(note);
        return ResponseEntity.ok(saveData);
    }

    //Todo: GetAll a note
    @GetMapping(value = "allnotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes(){
        return noteService.getAllNotes();
    }

    //Todo: SEARCH a note
    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public NoteDTO getNote(@PathVariable ("noteId") String noteId)  {
        return noteService.getSelectedNote(noteId);
    }

    //Todo: UPDATE a note
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDTO note) {
        try {
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Todo: DELETE a note
    @DeleteMapping(value ="/{noteId}" )
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
        return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
