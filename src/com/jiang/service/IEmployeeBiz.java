package com.jiang.service;

import java.util.List;

import com.jiang.po.Department;
import com.jiang.po.Employee;
import com.jiang.util.PageUtil;


public interface IEmployeeBiz {
	public boolean addE(Employee emp);
	
	public boolean deleteE( int employeeID );
	
	public boolean updateE(Employee emp);
	
	public List<Employee> findBy();
	
	public List<Employee> findAll(Employee employee, PageUtil pageUtil);
	
	//查询总数
	public int getCount(Employee employee);
	//模糊查询员工
	public List<Employee> findByName(Employee emp);
}
