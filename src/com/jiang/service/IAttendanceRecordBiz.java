package com.jiang.service;

import java.util.Date;
import java.util.List;

import com.jiang.po.AttendanceRecord;

public interface IAttendanceRecordBiz {
	public List<AttendanceRecord> queryAttendanceRecords(
			int departmentId , Date attendanceDate 
			, String attendanceTime 
			);
	//批量考勤录入
	public boolean batchAttendanceRecord(
			int departmentID , 
			Date attendanceDate ,
			String attendanceTime ,
			List<AttendanceRecord> list); 
	
}	
