package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.Department;
import com.jiang.po.DepartmentForTree;
import com.jiang.po.Position;
import com.jiang.service.IDepartmentBiz;
import com.jiang.service.Impl.DepartmentBizImpl;
import com.jiang.util.PageUtil;
@WebServlet("/DepartmentController/*")
public class DepartmentController extends HttpServlet {
	private IDepartmentBiz biz = new  DepartmentBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String opt = request.getAttribute("opt").toString();
		switch (opt)
		{
		case "queryAllDepartmentsForTree":
			queryAllDepartmentsForTree(request, response);
			break;
		case "queryAllOneDepartments":
			queryAllOneDepartments(request, response);
			break;
		case "queryTwoDepartments":
			queryTwoDepartments(request, response);
			break;
		case "addDept":
			addDept(request, response);
			break;
		
		case "addTwoDept":
			addTwoDept(request, response);
			break;
		case "updateDept":
			updateDept(request, response);
			break;
		case "updateTwoDept":
			updateTwoDept(request, response);
			break;
		case "deleteDept":
			deleteDept(request, response);
			break;
		case "queryTwoDepartment":
			queryTwoDepartment(request,response);
			break;
		case "queryAllOneDepartment":
			queryAllOneDepartment(request,response);
			break;
		case "deleteTwoDept":
			deleteTwoDept(request,response);
			break;
		case "queryAll":
			queryAll(request,response);
		}
		
		
	}

	private void queryAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<DepartmentForTree> departments = biz.queryAllDepartmentsForTree();
		departments.add( 
				new DepartmentForTree( 0 , "全部" ) );
		String jsonString = JSON.toJSONString(departments);
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();
		out.close();
		
	}

	private void updateTwoDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String departmentName = request.getParameter("departmentName");
		String startTimeAM = request.getParameter("startTimeAM");
		String endTimeAM = request.getParameter("endTimeAM");
		String startTimePM = request.getParameter("startTimePM");
		String endTimePM = request.getParameter("endTimePM");
		int parentID = Integer.parseInt(request.getParameter("parentID"));
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		Department dept = new Department(departmentID,departmentName,startTimeAM,endTimeAM,startTimePM,endTimePM,parentID);
		boolean result = biz.updateDept(dept);
		out.print(result);
		out.flush();
		out.close();
		
	}

	private void addTwoDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String departmentName = request.getParameter("departmentName");
		String startTimeAM = request.getParameter("startTimeAM");
		String endTimeAM = request.getParameter("endTimeAM");
		String startTimePM = request.getParameter("startTimePM");
		String endTimePM = request.getParameter("endTimePM");
		int parentID = Integer.parseInt(request.getParameter("parentID"));
		Department dept = new Department(departmentName,startTimeAM,endTimeAM,startTimePM,endTimePM,parentID);
		boolean result = biz.addDept(dept);
		out.print(result);
		out.flush();
		out.close();
		
	}

	private void deleteDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		boolean result = biz.deleteDept(departmentID);
		
		out.print(result);
		out.flush();
		out.close();
	}
	private void deleteTwoDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		boolean result = biz.deleteTwoDept(departmentID);
		
		out.print(result);
		out.flush();
		out.close();
	}

	private void updateDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String departmentName = request.getParameter("departmentName");
		
		String startTimeAM = request.getParameter("startTimeAM");
		
		String endTimeAM = request.getParameter("endTimeAM");
		
		String startTimePM = request.getParameter("startTimePM");
		
		String endTimePM = request.getParameter("endTimePM");
		//int parentID = Integer.parseInt(request.getParameter("parentID"));
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		Department dept = new Department(departmentID,departmentName,startTimeAM,endTimeAM,startTimePM,endTimePM);
		boolean result = biz.updateDept(dept);
		
		out.print(result);
		out.flush();
		out.close();
		
	}

	private void addDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String departmentName = request.getParameter("departmentName");

		String startTimeAM = request.getParameter("startTimeAM");
		String endTimeAM = request.getParameter("endTimeAM");
		String startTimePM = request.getParameter("startTimePM");
		String endTimePM = request.getParameter("endTimePM");
		Department dept = new Department(departmentName,startTimeAM,endTimeAM,startTimePM,endTimePM);
		dept.setParentID(0);
		
		boolean result = biz.addDept(dept);
		
		out.print(result);
		out.flush();
		out.close();
	}

	private void queryTwoDepartments(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int currentPageIndex = Integer.parseInt(page)- 1;
		int pageSize = Integer.parseInt(rows);
		HashMap<String,Object> map = new HashMap<String,Object>();
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int total = biz.getCountTwo(departmentID);
		PageUtil pager = new PageUtil(
				pageSize , currentPageIndex ,total 
				);
		List<Department> list = biz.queryTwoDepartments(departmentID,pager);
		map.put("total", total);
		map.put("rows" , list);
		String jsonString  = JSON.toJSONString(map);
		out.print(jsonString);
		out.flush();
		out.close();
	}
	public void queryTwoDepartment(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		List<Department> list = biz.queryTwoDepartment();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String jsonString = JSON.toJSONString(list);
		out.print(jsonString);
		out.flush();
		out.close();
		
	}
	private void queryAllOneDepartment(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Department> list = biz.queryAllOneDepartments();
		
		String jsonString  = JSON.toJSONString(list);
		out.print(jsonString);
		
		out.flush();
		out.close();
	}
	private void queryAllOneDepartments(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if(page==null){
			System.out.println("111");
		}
		int currentPageIndex = (Integer.parseInt( page )- 1 );
		
		int pageSize = Integer.parseInt(rows);
		HashMap<String,Object> map = new HashMap<String,Object>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int total = biz.getCount();
		PageUtil pager = new PageUtil(
				pageSize , currentPageIndex ,total 
				);
		List<Department> list = biz.queryAllOneDepartments(pager);
		map.put("total", total);
		map.put("rows" , list);
		String jsonString  = JSON.toJSONString(map);
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

	private void queryAllDepartmentsForTree(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<DepartmentForTree> list = biz.queryAllDepartmentsForTree();
		String jsonString  = JSON.toJSONString(list);
		out.print(jsonString);
		
		out.flush();
		out.close();
		
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
