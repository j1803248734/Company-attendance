package com.jiang.service.Impl;

import java.util.Date;
import java.util.List;

import com.jiang.dao.AttendanceDayDao;
import com.jiang.po.AttendanceRecord;
import com.jiang.service.AttendanceDayBiz;

public class AttendanceDayBizImpl implements AttendanceDayBiz{
	private AttendanceDayDao dao = new AttendanceDayDao();
	public List<AttendanceRecord> findByDay(Date attendanceDate, String attendanceTime) {
		String sql = "select  attendanceID,attendanceDate,attendanceTime,attendanceType,attendancetype.typeName,"
				+ "department.departmentID twoDID ,department.departmentName twoName,"
				+ "department.parentID oneDID,"
				+ "(select departmentName from department d1 where d1.departmentID = department.parentID)oneName , "
				+ "employee.employeeName, attendanceType.typeName"
				+ " from attendancerecord "
				+ " LEFT JOIN department ON attendancerecord.departmentID = department.departmentID "
				+ "LEFT JOIN attendancetype ON attendancerecord.attendanceType = attendancetype.typeID  "
				+ "LEFT JOIN employee ON attendancerecord.employeeID = employee.employeeID "
				+ "where attendanceDate = ? and attendanceTime = ?";
		return  dao.query(sql, AttendanceRecord.class, new Object[]{attendanceDate , attendanceTime});
	}

}
