package com.hj.pers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.pers.entites.impl.Note;
import com.hj.pers.resp.impl.NoteReposity;

@Service
@Transactional
public class NoteService {
	@Autowired
	private NoteReposity bs;
	@Autowired
	private UserService us;

	public Note save(Note note) {
		note = (Note) us.setCommonInfo(note);
		return bs.save(note);
	}

	public Note findOne(Long id) {
		return bs.findOne(id);
	}

	public Page<Note> queryRecentNote(Pageable pageable) {
		return bs.findAll(pageable);
	}

	public List<Note> queryNoteByWord(String keyword) {
		return bs.queryNoteByKeyword(keyword);
	}
}
