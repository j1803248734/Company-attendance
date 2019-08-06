package com.jiang.service.Impl;

import java.util.Arrays;
import java.util.List;

import com.jiang.dao.AttendanceSumDao;
import com.jiang.po.AttendanceRecord;
import com.jiang.po.Employee;
import com.jiang.service.AttendanceSumBiz;

public class AttendanceSumBizImpl implements AttendanceSumBiz{
	private AttendanceSumDao dao = new AttendanceSumDao();
	@Override
	public List<Employee> findAll(Employee employee) {
		String sql = "select emp.employeeID ,emp.employeeName,dep.departmentName twoName,deptOne.departmentName oneDName, emp.cardNumber,att.attendanceDate,att.attendanceDate, "
+"  min(case when att.attendanceTime = '上午' then type.typeName end) mType, "
+ " min(case when att.attendanceTime = '下午' then type.typeName end) aType   "
 +" from employee emp left JOIN department dep on emp.departmentID  =  dep.departmentID  "
+ " left JOIN department deptOne on dep.parentID = deptOne.departmentID  "
+" INNER JOIN attendancerecord att on att.employeeID = emp.employeeID  "
+" INNER JOIN attendanceType type on att.attendancetype = type.typeID  "
			+ " where 0=0 "; 
		
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		if(employee.getAttendanceDate()!=null
							&&!employee.getAttendanceDate().equals(""))
			
		{
			sb.append("and att.attendanceDate = ?");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] =  employee.getAttendanceDate(); 
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
		if(employee.getTypeID()!=0)
		{
			sb.append(" and type.typeID = ?");
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[objs.length-1] = employee.getTypeID();
		}
		
		if(employee.getEmployeeName() != null 
				&& !employee.getEmployeeName().equals(""))
		{
			
			sb.append(" and emp.employeeName like ? ");
			objs = Arrays.copyOf(objs,objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + employee.getEmployeeName() + "%";
		}
		if(employee.getAttendanceType() != null 
				&& !employee.getAttendanceType().equals(""))
		{
			
			sb.append(" and type.typeID in (?)");
			objs = Arrays.copyOf(objs,objs.length+1);
			objs[objs.length-1] = employee.getAttendanceType();
		}
		sb.append(" GROUP BY emp.employeeID,emp.cardNumber,att.attendanceDate ");
		System.out.println(sb.toString());
		List<Employee> list =  dao.query(sb.toString(), Employee.class, objs);
		return list;
	}
	
}
