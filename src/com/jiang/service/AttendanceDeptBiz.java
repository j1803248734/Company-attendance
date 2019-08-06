package com.jiang.service;

import java.util.List;

import com.jiang.po.AttendanceRecord;
import com.jiang.po.Employee;

public interface AttendanceDeptBiz {
	public List<Employee> queryDepartmentCompreStatistics( Employee employee );
}
