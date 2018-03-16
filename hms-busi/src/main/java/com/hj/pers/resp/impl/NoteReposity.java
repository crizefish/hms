package com.hj.pers.resp.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import com.hj.pers.entites.impl.Note;
import com.hj.pers.resp.BaseRepository;

public interface NoteReposity extends BaseRepository<Note, Long> {
	@Query(value = "select * from note order by create_Date desc limit ?1", nativeQuery = true)
	public List<Note> queryRecentNote(Long count);

	@Query(value = "SELECT * FROM note WHERE content LIKE %" + "?1" + "% ", nativeQuery = true)
	public List<Note> queryNoteByKeyword(String keyWord);

	public Page<Note> findAll(Pageable pageable);

}
