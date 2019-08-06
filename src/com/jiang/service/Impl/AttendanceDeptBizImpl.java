package com.jiang.service.Impl;

import java.util.Arrays;
import java.util.List;

import com.jiang.dao.AttendanceDeptDao;
import com.jiang.po.AttendanceRecord;
import com.jiang.po.Employee;
import com.jiang.service.AttendanceDeptBiz;

public class AttendanceDeptBizImpl implements AttendanceDeptBiz{
	private AttendanceDeptDao dao = new AttendanceDeptDao();
	@Override
	public List<Employee> queryDepartmentCompreStatistics( Employee employee ) {
		String sql = " SELECT "
				+ " emp.employeeID,emp.employeeName,emp.cardNumber,deptOne.DepartmentName oneDName,dept.DepartmentName twoName, "
				+ " count(case when att.attendanceType = 1 then att.attendanceType end)*0.5 'attendance', "
				+ "	count(case when att.attendanceType = 2 then att.attendanceType end)*0.5 'illness', "
				+ "	count(case when att.attendanceType = 3 then att.attendanceType end)*0.5 'yield', "
				+ "	count(case when att.attendanceType = 4 then att.attendanceType end)*0.5 'matter', "
				+ "	count(case when att.attendanceType = 6 then att.attendanceType end)*0.5 'late', "
				+ "	count(case when att.attendanceType = 7 then att.attendanceType end)*0.5 'absenteeism', "
				+ "	count(case when att.attendanceType = 12 then att.attendanceType end)*0.5 'marry', "
					+ "	count(case when att.attendanceType = 13 then att.attendanceType end)*0.5 'lose' "
				+ " FROM employee emp "
				+ " INNER JOIN attendancerecord att ON emp.EmployeeID = att.EmployeeID "
				+ " LEFT OUTER JOIN department dept ON emp.DepartmentID = dept.DepartmentID "
				+ " LEFT OUTER JOIN department deptOne ON dept.ParentID = deptOne.DepartmentID "
				+ " WHERE 0=0  " ;
				
				
		
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		if(employee.getSel1()!=0
							)
			
		{
			sb.append(" and YEAR(att.attendanceDate) =?");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] =  employee.getSel1(); 
		}
		if(employee.getSel2()!=0)

			{
			sb.append(" AND MONTH(att.AttendanceDate) = ?");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] =  employee.getSel2(); 
			}
		if(employee.getStartDate()!=null&&!employee.getStartDate().equals(""))
		{
			sb.append("  and att.attendanceDate>=? ");
			objs = Arrays.copyOf(objs, objs.length + 1);
			objs[ objs.length - 1 ] = employee.getStartDate();
		}
		if(employee.getEndDate()!=null&&!employee.getEndDate().equals(""))
		{
			sb.append("  and att.attendanceDate<= ?  ");
			objs = Arrays.copyOf(objs, objs.length + 1);
			objs[ objs.length - 1 ] = employee.getEndDate();
		}
		if(employee.getDepartmentID()!=0)
		{
			sb.append("and emp.departmentID = ?");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[objs.length-1] = employee.getDepartmentID();
			
		}
		
		sb.append(" GROUP BY emp.employeeID,emp.cardNumber  ");
		
		List<Employee> list =  dao.query(sb.toString(), Employee.class, objs);
		return list;
	}
	
}
	