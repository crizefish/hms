package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.entites.impl.Note;
import com.hj.pers.resp.impl.NoteReposity;
@Service
@Transactional
public class NoteService {
@Autowired 
NoteReposity bs;

	public Note save(Note note) {
		return bs.save(note);
	}

	public Note findOne(Long id) {
		return bs.findOne(id);
	}
	
	public List<Note> queryRecentNote(Long count) {
		return bs.queryRecentNote(count).size()>0?bs.queryRecentNote(count):null;
	}
	public List<Note> queryNoteByWord(String keyword) {
		return bs.queryNoteByKeyword(keyword);
	}
}
