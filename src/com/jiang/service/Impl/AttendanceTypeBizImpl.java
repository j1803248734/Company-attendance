package com.jiang.service.Impl;

import java.util.List;

import com.jiang.dao.AttendanceTypeDao;
import com.jiang.po.AttendanceType;
import com.jiang.service.IAttendanceTypeBiz;

public class AttendanceTypeBizImpl implements IAttendanceTypeBiz{
	private AttendanceTypeDao dao = new AttendanceTypeDao();

	public List<AttendanceType> queryAllAttendanceTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from attendancetype where typeCategory = 0";
		
		return dao.query(sql, AttendanceType.class,new Object[]{});
	}
	public List<AttendanceType> queryAllLeaveTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from attendancetype where typeCategory = 1";
		
		return dao.query(sql, AttendanceType.class,new Object[]{});
	}
	@Override
	public List<AttendanceType> queryAllTypes() {
		String sql = "select * from attendancetype";
		return dao.query(sql, AttendanceType.class, new Object[]{});
	}
	
	
}
