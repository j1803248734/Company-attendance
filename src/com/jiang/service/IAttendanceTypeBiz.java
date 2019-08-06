package com.jiang.service;

import java.util.List;

import com.jiang.po.AttendanceType;

public interface IAttendanceTypeBiz {
	
	public List<AttendanceType> queryAllAttendanceTypes();
	
	public List<AttendanceType> queryAllLeaveTypes();
	
	public List<AttendanceType> queryAllTypes();
}
