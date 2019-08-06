package com.jiang.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.jiang.dao.EmployeeDao;
import com.jiang.po.Department;
import com.jiang.po.Employee;
import com.jiang.service.IEmployeeBiz;
import com.jiang.util.JDBCUtils;
import com.jiang.util.PageUtil;

public class EmployeeBizImpl implements IEmployeeBiz{
	private EmployeeDao dao = new EmployeeDao();
	@Override
	public boolean addE(Employee emp) {
		String sql= "insert into employee (employeeName,employeeGender,positionID,departmentID,cardNumber,employeeState,employeeMemo) values(?,?,?,?,?,?,?)";
		Object [] params = {
				emp.getEmployeeName(),
				emp.getEmployeeGender(),
				emp.getPositionID(),
				emp.getDepartmentID(),
				emp.getCardNumber(),
				emp.getEmployeeState(),
				emp.getEmployeeMemo()
		};
		
		return dao.update(sql, params);
	}

	@Override
	public boolean deleteE(int employeeID) {
		boolean result = true;
		Connection conn = JDBCUtils.getConnection();
		try {
			String sql1 = "select employeeState from employee where employeeID = ?";
			Object [] param1 = {
				employeeID
			};
			Employee emp = (Employee) dao.get(conn,sql1, Employee.class, param1);
			
		if(emp.getEmployeeState().equals("0"))
		{
			
			String sql2 = "delete from employee where employeeID = ?";
			Object [] param2 = {
					employeeID
				};
			dao.update(sql2, param2);
			conn.setAutoCommit(false);
		}else{
			
			return false;
		}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("失败---------");
			JDBCUtils.rollback();
			result = false;
		}
		return result;
	}

	@Override
	public boolean updateE(Employee emp) {
		String sql = "update employee set employeeName = ? , employeeGender = ? , positionID = ? , departmentID = ? , cardNumber = ?"
				+ " ,employeeState = ? , employeeMemo = ? where employeeID = ?";
		Object [] params = {
				emp.getEmployeeName(),
				emp.getEmployeeGender(),
				emp.getPositionID(),
				emp.getDepartmentID(),
				emp.getCardNumber(),
				emp.getEmployeeState(),
				emp.getEmployeeMemo(),
				emp.getEmployeeID()
		};
		return dao.update(sql, params);
	}

	@Override
	public List<Employee> findBy() {
		String sql = "select employeeID,employeeName,employeeGender,positionID ,"
				+ "(select positionName from position where employee.positionID = position.positionID)positionName,departmentID "
				+ ",(select departmentName from department where  employee.departmentID = department.departmentID)departmentName"
				+ ",cardNumber,employeeState,employeeMemo from employee  ";
		//Object [] params = {employeeID} ;
		return  dao.query(sql, Employee.class);
	}

	@Override
	public List<Employee> findAll(Employee employee, PageUtil pageUtil) {
		String sql =  "select employeeID,employeeName,employeeGender,positionID,"
				+ "(select positionName from position where employee.positionID = position.positionID)positionName,departmentID"
				+ ",(select departmentName from department where  employee.departmentID = department.departmentID)departmentName"
				+ ",cardNumber,employeeState,employeeMemo from employee  where 1=1";
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		if( employee.getEmployeeName() != null 
				&& !employee.getEmployeeName().equals("") )
		{
			sb.append(" AND  employee.EmployeeName like ? ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + employee.getEmployeeName() + "%";
			//System.out.println("员工姓名：" + objs[ objs.length - 1 ]);
			
		}
		if( employee.getDepartmentID() != 0 )
		{
			sb.append( " AND  employee.DepartmentID = ? " );
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = employee.getDepartmentID();
		}
		sb.append(" limit ? , ? ");
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getStartIndex();
		
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getPageSize();
		
		return dao.query(sb.toString(), Employee.class,objs);
	}

	@Override
public int getCount(Employee employee) {
		
		
		String sql = " SELECT count(*) total  "
				+ " FROM employee inner join department "
				+ "  	on department.departmentID = employee.departmentID  "
				+ " WHERE 0 = 0 ";
		
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		
		if( employee.getEmployeeName() != null 
				&& !employee.getEmployeeName().equals("") )
		{
			sb.append(" AND  employee.EmployeeName like ? ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + employee.getEmployeeName() + "%";
			//System.out.println("员工姓名：" + objs[ objs.length - 1 ]);
			
		}
		
		
		
		if( employee.getDepartmentID() != 0 )
		{
			sb.append( " AND  employee.DepartmentID = ? " );
			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = employee.getDepartmentID();
		}
		
		
		
		
		return  (int) dao.getCount(sb.toString(), objs);
	}

	@Override
	public List<Employee> findByName(Employee emp) {
		String sql = "	select employeeID,d.parentID oneID,d.departmentID twoDID,d.departmentName twoName,d.parentID oneDID,"
				+ "   d.startTimeAM,d.endTimeAM,d.startTimePM,d.endTimePM,   "
					+"	(select departmentName from department d1 where d.parentID = d1.departmentID) "
					+"	oneDName ,cardNumber ,employeeName  from employee LEFT OUTER JOIN department d   "
					+"	ON employee.departmentID = d.departmentID     "
				+ "   where 0=0";
			StringBuilder sb = new StringBuilder(sql);
			Object[] objs = new Object[]{};
			if( emp.getEmployeeName() != null 
					&& !emp.getEmployeeName().equals("") )
			{
				sb.append(" AND employee.employeeName like ? ");
	
				objs = Arrays.copyOf(objs, objs.length+1);
				objs[ objs.length - 1 ] = 
						"%" + emp.getEmployeeName() + "%";
				//System.out.println("员工姓名：" + objs[ objs.length - 1 ]);
			
		}
			
			List<Employee> list=dao.query(sb.toString(), Employee.class, objs);
			
		return list;
	}


}
