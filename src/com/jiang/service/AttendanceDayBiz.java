package com.jiang.service;

import java.util.Date;
import java.util.List;

import com.jiang.po.AttendanceRecord;

public interface AttendanceDayBiz {
	public List<AttendanceRecord> findByDay(Date attendanceDate, String attendanceTime);
}
