package com.jiang.service.Impl;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.jiang.dao.NoteDao;
import com.jiang.po.Note;
import com.jiang.service.INoteBiz;
import com.jiang.util.PageUtil;

public class NoteBizImpl implements INoteBiz{
	private NoteDao dao = new NoteDao();
	@Override
	public List<Note> queryAllNotes() {
		String sql = "SELECT" + 
				"			note.noteID,note.fillInTime,note.employeeID," + 
				"			employee.cardNumber,employee.employeeName," + 
				"			d.departmentID twoDID,d.departmentName twoName,d.parentID oneDID," + 
				"			(" + 
				"				select departmentName from department d1 where d.parentID = d1.departmentID" + 
				"			)oneDName," + 
				"			t.typeID,t.typeName,note.startDate,note.startTime,note.endDate,note.endTime,note.operatorID," + 
				"			(" + 
				"				select e1.employeeName FROM employee e1 where note.operatorID = e1.employeeID" + 
				"			)operatorName" + 
				"		FROM note INNER JOIN employee" + 
				"			ON note.employeeID = employee.employeeID" + 
				"			LEFT OUTER JOIN department d" + 
				"			ON employee.departmentID = d.departmentID" + 
				"			LEFT OUTER JOIN attendancetype t" + 
				"			on note.noteTypeID = t.typeID";
		
		
		return dao.query(sql, Note.class, new Object[] {});
	}
	@Override
public List<Note> queryAllNotes(Note note, PageUtil pageUtil) {
		
		

		String sql = "SELECT" + 
				"			note.noteID,note.fillInTime,note.employeeID," + 
				"			employee.cardNumber,employee.employeeName," + 
				"			d.departmentID twoDID,d.departmentName twoName,d.parentID oneDID," + 
				"			(" + 
				"				select departmentName from department d1 where d.parentID = d1.departmentID" + 
				"			)oneDName," + 
				"			t.typeID,t.typeName,note.startDate,note.startTime,note.endDate,note.endTime,note.operatorID," + 
				"			(" + 
				"				select e1.employeeName FROM employee e1 where note.operatorID = e1.employeeID" + 
				"			)operatorName" + 
				"		FROM note INNER JOIN employee" + 
				"			ON note.employeeID = employee.employeeID" + 
				"			LEFT OUTER JOIN department d" + 
				"			ON employee.departmentID = d.departmentID" + 
				"			LEFT OUTER JOIN attendancetype t" + 
				"			on note.noteTypeID = t.typeID"
				+ " WHERE 0 = 0 ";
		
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		
		if( note.getAdminID() != 0 ) //Session值
		{
			sb.append(" AND  note.adminId = ? ");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getAdminID();
		}
		
		if( note.getEmployeeName() != null 
				&& !note.getEmployeeName().equals("") )
		{
			sb.append(" AND  employee.EmployeeName like ? ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + note.getEmployeeName() + "%";
			System.out.println("员工姓名：" + objs[ objs.length - 1 ]);
			
		}
		
		if(note.getNoteTypeID() != 0 )
		{
			sb.append(" AND  note.NoteTypeID = ?  ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getNoteTypeID();
		}
		
		if( note.getDepartmentID() != 0 )
		{
			sb.append( " AND  note.DepartmentID = ? " );
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getDepartmentID();
		}
		
		if( note.getStartDate() != null)
		{
			sb.append(" AND (note.EndDate > ? and note.StartDate < ? ) ");
			objs = Arrays.copyOf(objs, objs.length+2);
			objs[ objs.length - 2 ] = note.getStartDate();
			objs[ objs.length - 1 ] = note.getStartDate();
		}
		
		
		sb.append(" limit ? , ? ");
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getStartIndex();
		
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getPageSize();
		
	
		
		List<Note> list = 
				dao.query(sb.toString(), 
						Note.class, objs);
		
		return list;
	}

	@Override
	public int getCount(Note note) {
		
		
		String sql = " SELECT count(*) total  "
				+ " FROM note inner join employee "
				+ "  	on note.employeeID = employee.employeeID  "
				+ " WHERE 0 = 0 ";
		
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		
		if( note.getAdminID() != 0 ) //Session值
		{
			sb.append(" AND  note.adminID = ? ");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getAdminID();
		}
		
		if( note.getEmployeeName() != null 
				&& !note.getEmployeeName().equals("") )
		{
			sb.append(" AND  employee.employeeName like ? ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + note.getEmployeeName() + "%";
			//System.out.println("员工姓名：" + objs[ objs.length - 1 ]);
			
		}
		
		if(note.getNoteTypeID() != 0 )
		{
			sb.append(" AND  note.noteTypeID = ?  ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getNoteTypeID();
		}
		
		if( note.getDepartmentID() != 0 )
		{
			sb.append( " AND  note.departmentID = ? " );
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = note.getDepartmentID();
		}
		
		if( note.getStartDate() != null)
		{
			sb.append(" AND (note.endDate > ? and note.startDate < ? ) ");
			objs = Arrays.copyOf(objs, objs.length+2);
			objs[ objs.length - 2 ] = note.getStartDate();
			objs[ objs.length - 1 ] = note.getStartDate();
		}
		
		
		return (int) dao.getCount(sb.toString(), objs);
	}
	@Override
	public Note queryNoteByPK(int noteID) {
		String sql="select note.*,emp.employeeName,"
				+ "empo.employeeName operatorName ,department.startTimeAM,"
				+ "department.endTimeAM,department.startTimePM,department.endTimePM "
				+ "from note  "
				+ "left join employee emp  "
				+ "on note.employeeID = emp.employeeID "
				+ "left join employee empo on note.operatorID = empo.employeeID "
				+ "	left join department on note.departmentID = department.departmentID     "
				+ "  where noteID = ?";
		Object [] params = {noteID};
		
		Note note = (Note) dao.get(sql, Note.class, params);
		
		return  note;
	}
	@Override
	public boolean addNote(Note note) {
		String sql = "INSERT INTO note ( departmentID , "
				+ " employeeID , noteTypeID , "
				+ " cause , fillInTime , "
				+ "directorSign , administrationSign ,"
				+ " presidentSign , "
				+ " startDate , startTime , endDate , "
				+ "endTime , adminID , operatorID , "
				+ " isVerify )VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1') ";
		
		return dao.update(sql, 
				new Object[]{
					note.getDepartmentID(),
					note.getEmployeeID(),
					note.getNoteTypeID(),
					note.getCause(),
					note.getFillInTime(),
					note.getDirectorSign(),
					note.getAdministrationSign(),
					note.getPresidentSign(),
					note.getStartDate(),
					note.getStartTime(),
					note.getEndDate(),
					note.getEndTime(),
					note.getAdminID(),
					note.getOperatorID()
					
					}
				);
	}
	@Override
	public boolean updateNote(Note note) {
		String sql = "update note set departmentID  =?, "
				+ " employeeID = ?, noteTypeID =?, "
				+ " cause =?, fillInTime=? , "
				+ "directorSign=? , administrationSign=? ,"
				+ " presidentSign=? , "
				+ " startDate=? , startTime=? , endDate =?, "
				+ "endTime=? , adminID=? , operatorID =? , "
				+ " isVerify =1 where noteID =? ";
		return dao.update(sql, 
				new Object[]{
					note.getDepartmentID(),
					note.getEmployeeID(),
					note.getNoteTypeID(),
					note.getCause(),
					note.getFillInTime(),
					note.getDirectorSign(),
					note.getAdministrationSign(),
					note.getPresidentSign(),
					note.getStartDate(),
					note.getStartTime(),
					note.getEndDate(),
					note.getEndTime(),
					note.getAdminID(),
					note.getOperatorID(),
					note.getNoteID()
					}
				);
	}
	public boolean deleteNote(int noteID) {
		String sql = "delete from note where noteID = ? ";
		return dao.update(sql, new Object[]{noteID}
				
				);
	}
	@Override
	public List<Note> queryByCardNumber(String cardNumber, Date attentanceDate) {
		String sql = " SELECT Note.noteID, "
				+ "   employee.cardNumber ,  "
				+ "   employee.employeeName , "
				+ "   note.startDate , "
				+ "   note.startTime , "
				+ "   note.endDate , "
				+ "   note.endTime , "
				+ "   attendancetype.typeName "
				+ " FROM Note INNER JOIN employee  "
				+ " ON Note.employeeID = employee.employeeID  "
				+ " INNER JOIN attendancetype "
				+ " ON note.noteTypeID = attendancetype.typeID "
				+ " WHERE "
				+ " 	note.startDate <= ?  "
				+ " 	AND note.endDate >= ? "
				+ "     AND cardNumber = ?   ";
		
		return dao.query(sql, Note.class, new Object[]{attentanceDate,attentanceDate,cardNumber});
	}
	
}

