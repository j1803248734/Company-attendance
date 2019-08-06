package com.jiang.service;

import java.util.List;

import com.jiang.po.AttendanceRecord;
import com.jiang.po.Employee;

public interface AttendanceSumBiz {
	public List<Employee> findAll(Employee employee);
}
 