package com.jiang.service;


import java.util.Date;
import java.util.List;

import com.jiang.po.AttendanceType;
import com.jiang.po.Note;
import com.jiang.util.PageUtil;

public interface INoteBiz  {
	public List<Note> queryAllNotes();

	public List<Note> queryAllNotes(Note note , PageUtil pageUtil);

	public int getCount(Note note);	
	
	//按照单据编号进行查询
	public Note queryNoteByPK( int noteID );
	
	public boolean addNote(Note note);
	
	public boolean updateNote(Note note);
	
	public boolean deleteNote(int noteID); 
	
	public List<Note> queryByCardNumber( String cardNumber ,Date attentanceDate );
	
	
}
