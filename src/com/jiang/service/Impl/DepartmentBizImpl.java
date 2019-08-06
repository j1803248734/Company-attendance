 package com.jiang.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jiang.dao.DepartmentDao;
import com.jiang.po.Department;
import com.jiang.po.DepartmentForTree;
import com.jiang.po.Employee;
import com.jiang.service.IDepartmentBiz;
import com.jiang.util.JDBCUtils;
import com.jiang.util.PageUtil;

public class DepartmentBizImpl implements IDepartmentBiz{
	private  DepartmentDao dao = new DepartmentDao();
	public List<DepartmentForTree> queryAllDepartmentsForTree() {
		
		String sql = "SELECT "
				+ " departmentID id , departmentName text "
				+ ", parentID pid "
				+ " FROM department order by parentID asc";
		
		List<DepartmentForTree> departments =
			dao.query(sql, DepartmentForTree.class, new Object[]{});
		
		List<DepartmentForTree> ones = new ArrayList<DepartmentForTree>();
		List<DepartmentForTree> twos = new ArrayList<DepartmentForTree>();
		
		for (DepartmentForTree department : departments) {
			if(department.getPid() == 0)
			{
				
				ones.add( department );
			}else
			{
				twos.add( department);
			}
		} 
		
		for (DepartmentForTree departmentOne : ones) {
			for (DepartmentForTree departmentTwo : twos) {
				if( departmentOne.getId() ==
						departmentTwo.getPid())
				{
					departmentOne.getChildren()
						.add(departmentTwo);
				}
			}
		}
		
		return ones;
	}
//	public static void main(String[] args) {
//		List<Department> list = new  DepartmentBizImpl().queryAllDepartments();
//	for(Department department:list)
//		{
//			System.out.println(department);
//		}
//	}
	@Override
	public List<Department> queryAllOneDepartments() {
		String sql = "select * from department where parentID = 0";
		return dao.query(sql, Department.class, new Object[]{});
	}
	@Override
	public List<Department> queryTwoDepartments(int departmentID) {
		String sql = "select * from department where parentID = ? limit ? , ?"; 
		Object [] params = { departmentID  };
		return dao.query(sql, Department.class, params);
	}
	public List<Department> queryAll()
	{
		String sql = "SELECT DepartmentID , DepartmentName , ParentID  FROM department order by ParentID asc";
		List<Department> departments =
				dao.query(sql, Department.class, new Object[]{});
		return departments;
	}
	@Override
	public List<Department> queryAllOneDepartments(
			PageUtil pageUtil) {
		String sql = "select * from department where parentID = 0";
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		sb.append(" limit ? , ? ");
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getStartIndex();
		
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getPageSize();
		return dao.query(sb.toString(), Department.class, objs);
	}
	@Test
	public List<Department> queryTwoDepartments(int departmentID,
			 PageUtil pageUtil) {
		String sql = "select * from department where parentID = ? limit ? , ?"; 
		Object [] params = { departmentID  ,pageUtil.getStartIndex() , 
				pageUtil.getPageSize()};
		return  dao.query(sql, Department.class, params);
	}
	public List<Department> queryTwoDepartment() {
		String sql = "select * from department "; 
		
		return dao.query(sql, Department.class, new Object[]{});
	}
	
	@Override
	public boolean addDept(Department dept) {
		boolean result = true;
		//JDBCUtils.startTransaction();
		try {
			String sql1 = "select departmentName from department";
			List<Department> list = (List<Department>) dao.query(sql1, Department.class, new Object[]{});
			for(Department department:list)
			{
				if(department.getDepartmentName()==dept.getDepartmentName() || department.getDepartmentName().equals(dept.getDepartmentName()))
				{
					return result = false;
				}
			}
			String sql2 = "insert into department (departmentName,startTimeAM,endTimeAM,startTimePM,endTimePM,parentID) values(?,?,?,?,?,?)";
			Object [] params = {
					dept.getDepartmentName(),
					dept.getStartTimeAM(),
					dept.getEndTimeAM(),
					dept.getStartTimePM(),
					dept.getEndTimePM(),
						dept.getParentID()
			};
			dao.update(sql2, params);
			//JDBCUtils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			//JDBCUtils.rollback();//回滚事务
			result = false;
		}
		return result;
	}

	public boolean updateDept(Department dept) {
			boolean result = true;
			try {
					String sql1 = "select departmentName from department";
					List<Department> list = (List<Department>) dao.query(sql1, Department.class, new Object[]{});
					for(Department department:list)
					{
						if(department.getDepartmentName()==dept.getDepartmentName() || department.getDepartmentName().equals(dept.getDepartmentName()))
						{
							return result = false;
						}
					}
					
					String sql2 = "update department set departmentName = ? , startTimeAM = ? , "
							+ "endTimeAM = ? , startTimePM = ? , endTimePM = ? , parentID = ? where departmentID = ?";
					Object [] params = {
							dept.getDepartmentName(),
							dept.getStartTimeAM(),
							dept.getEndTimeAM(),
							dept.getStartTimePM(),
							dept.getEndTimePM(),
							dept.getParentID(),
							dept.getDepartmentID()
		
					};
						dao.update(sql2, params);
			} catch (Exception e) {
						e.printStackTrace();
						
						//JDBCUtils.rollback();//回滚事务
						result = false;
			}
		return result;
		
	}

	public boolean deleteDept(int departmentID) {
		boolean result = true;
		Connection conn = JDBCUtils.getConnection();
		
		try{
		//	conn.setAutoCommit(false);
			String sql1="select * from department left outer join employee on department.departmentID = employee.departmentID "
					+ "left outer  join  note on  department.departmentID = note.departmentID "
					+ "where department.parentID  = ? ";
			Object [] param1 = { departmentID };
			Department dept =  (Department) dao.get(conn, sql1, Department.class, param1);
			
			if(dept != null)
			{
				return result = false;
			}else{
				
				String sql2 = "delete from department where departmentID = ? ";
				Object [] param2 = { departmentID };
				dao.update(sql2, param2);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		//	JDBCUtils.rollback();//回滚事务
			result = false;
		}
		
		return result;
		
	}
	
	public boolean deleteTwoDept(int departmentID) {
		boolean result = true;
		Connection conn = JDBCUtils.getConnection();
		
		try{
		//	conn.setAutoCommit(false);
			String sql1="select * from department "
					+ "left outer join employee on department.departmentID = employee.departmentID "
					+ " left outer  join  note on  department.departmentID = note.departmentID  "
					+ " left outer  join  adminpopedom on  department.departmentID = adminpopedom.departmentID "
					+ " left outer  join  attendancerecord on  department.departmentID = attendancerecord.departmentID "
					+ "where note.departmentID  = ? or employee.departmentID = ? or adminpopedom.departmentID = ? or attendancerecord.departmentID =?";
			Object [] param1 = { departmentID ,departmentID,departmentID ,departmentID };
			Department dept =  (Department) dao.get(conn, sql1, Department.class, param1);
			
			if(dept != null)
			{
				return result = false;
			}else{
				
				String sql2 = "delete from department where departmentID = ? ";
				Object [] param2 = { departmentID };
				dao.update(sql2, param2);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		//	JDBCUtils.rollback();//回滚事务
			result = false;
		}
		
		return result;
		
	}
	@Test
	public int getCount() {
		
		
		String sql = " SELECT count(*) total  "
				+ " FROM department where parentID = 0";

		return  (int) dao.getCount(sql, new Object[]{});
	}
	public int getCountTwo(int departmentID) {
		
		
		String sql = " SELECT count(*) total  "
				+ " FROM department where parentID = ?";

		return  (int) dao.getCount(sql, new Object[]{departmentID});
	}
}
