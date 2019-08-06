package com.jiang.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jiang.dao.AttendanceRecordDao;
import com.jiang.po.AttendanceRecord;
import com.jiang.service.IAttendanceRecordBiz;
import com.jiang.util.JDBCUtils;

public class AttendanceRecordBizImpl implements IAttendanceRecordBiz{
	private AttendanceRecordDao dao = new  AttendanceRecordDao();
	
	@Override
	public List<AttendanceRecord> queryAttendanceRecords(int departmentID,
			Date attendanceDate, String attendanceTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = " SELECT "
				+ " employee.EmployeeID,employee.cardNumber,employee.employeeName ,"
				+ " convert('" + sdf.format(attendanceDate) + "' , date) attendanceDate, "
				+ " '" + attendanceTime + "' attendanceTime, "
				+ " d.departmentName ,  "
				+ " att.attendanceType , "
				+ " att.noteId  "
				+ " FROM employee "
				+ " LEFT OUTER JOIN attendancerecord att  "
				+ " ON employee.employeeID = att.employeeID  "
				+ " AND att.attendanceDate = ?  "
				+ " AND att.attendanceTime = ? "
				+ " LEFT OUTER JOIN department d  "
				+ " ON employee.departmentID = d.departmentID  "
				+ " LEFT OUTER JOIN note "
				+ " ON att.noteId = note.noteID  "
				+ " WHERE "
				+ " 	employee.departmentID = ? ";
		return  dao.query(sql, AttendanceRecord.class
				, new Object[]{attendanceDate , attendanceTime ,
			departmentID});
	}
	@Override
	public boolean batchAttendanceRecord(int departmentID, Date attendanceDate,String attendanceTime,
			List<AttendanceRecord> list) {
		// TODO Auto-generated method stub
		String sql = " delete from attendancerecord where departmentID = ? and attendanceDate = ? "
				+ "and attendanceTime = ? ";
		Connection conn = null;
		try {
			
			conn = JDBCUtils.getConnection();
			JDBCUtils.startTransaction();
			dao.update(conn, sql, new Object[]{departmentID,attendanceDate,attendanceTime});
			for(AttendanceRecord attendanceRecord:list)
			{
				String insertsql = " insert into attendancerecord ( employeeID , cardNumber , attendanceDate , attendanceTime , attendanceType , "
						+ "adminID , departmentID , noteID ) values ( ?,?,?,?,?,?,?,? )";
				boolean result = dao.update(conn, insertsql, new Object[]{
						attendanceRecord.getEmployeeID(),
						attendanceRecord.getCardNumber(),
						attendanceRecord.getAttendanceDate(),
						attendanceRecord.getAttendanceTime(),
						attendanceRecord.getAttendanceType(),
						attendanceRecord.getAdminID(),
						attendanceRecord.getDepartmentID(),
						attendanceRecord.getNoteID()
				});
				if( result ==false )
				{
					conn.rollback();
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtils.closeConnection();
		}
		return true;
	}

}
