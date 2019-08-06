package com.jiang.service;
import com.jiang.po.Department;
import com.jiang.po.DepartmentForTree;
import com.jiang.util.PageUtil;

import java.util.List;


public interface IDepartmentBiz {
		//树状下拉框数据
		public List< DepartmentForTree > queryAllDepartmentsForTree();
		//查询一级部门
		public List< Department > queryAllOneDepartments();
		public List< Department > queryAllOneDepartments(PageUtil page);
		//查询旗下子部门
		public List< Department > queryTwoDepartments(int departmentID);
		public List< Department > queryTwoDepartments(int departmentID,PageUtil page);
		//增加一级部门
		public boolean addDept(Department dept);
		//修改一级部门
		public boolean updateDept(Department dept);
		//删除一级部门
		public boolean deleteDept(int departmentID);
		//增加二级部门
		public List<Department> queryTwoDepartment();
		public int getCount();
		public int getCountTwo(int departmentID);
		public boolean deleteTwoDept(int departmentID);
		//查询所有。。。
		public List<Department> queryAll();
}
