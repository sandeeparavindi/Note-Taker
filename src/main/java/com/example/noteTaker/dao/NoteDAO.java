package com.example.noteTaker.dao;

import com.example.noteTaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<NoteEntity, String> {

}
