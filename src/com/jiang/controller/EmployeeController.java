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

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.jiang.po.Department;
import com.jiang.po.Employee;
import com.jiang.po.Note;
import com.jiang.po.Position;
import com.jiang.service.IEmployeeBiz;
import com.jiang.service.Impl.EmployeeBizImpl;
import com.jiang.util.PageUtil;
@WebServlet("/EmployeeController/*")
public class EmployeeController extends HttpServlet {
	private IEmployeeBiz biz = new EmployeeBizImpl();
	/**
	 * Constructor of the object.
	 */
	public EmployeeController() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			String opt = request.getAttribute("opt").toString();
			switch (opt)
			{
			case "queryAllEmployees":
				queryAllEmployees(request, response);
				break;
			case "addEmployee":
				addEmployee(request,response);
				break;
			case "updateEmployee":
				updateEmployee(request,response);
				break;
			case "deleteEmployee":
				deleteEmployee(request,response);
				break;
			case "queryEmployee":
				queryEmployee(request, response);
				break;
			case "findByName":
				findByName(request, response);
				break;
			
			
			}
		
	}

	

	
	
	private void findByName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			PrintWriter out = response.getWriter();
			
		//	int employeeID = Integer.parseInt(request.getParameter("employeeID"));
			Employee employee = new Employee();
			
			if( request.getParameter("employeeName") != null 
					&& !request.getParameter("employeeName").equals(""))
			{
				employee.setEmployeeName(request.getParameter("employeeName"));
			}
			
			List<Employee> list = biz.findByName(employee);
			String jsonString = JSON.toJSONString(list);
			
			out.print(jsonString);
			out.flush();
			out.close();
		
	}
	
	private void queryEmployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	//	int employeeID = Integer.parseInt(request.getParameter("employeeID"));

		List<Employee> emp = biz.findBy();
		String jsonString = JSON.toJSONString(emp);
		
		out.print(jsonString);
		out.flush();
		out.close();
	}

	private void deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		
		boolean result = biz.deleteE(employeeID);
		
		
		out.print(result);
		out.flush();
		out.close();
	}

	private void updateEmployee(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String employeeName = request.getParameter("employeeName");
		
		String EmployeeGender = request.getParameter("employeeGender");
		
		int PositionID = Integer.parseInt(request.getParameter("positionName"));

		int DepartmentID = Integer.parseInt(request.getParameter("departmentName"));
		String CardNumber = request.getParameter("cardNumber");
		String EmployeeState = request.getParameter("employeeState");
		String EmployeeMemo = request.getParameter("employeeMemo");
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		Employee emp = new Employee(employeeID,employeeName,EmployeeGender,PositionID,DepartmentID,CardNumber,EmployeeState,EmployeeMemo);
		boolean result = biz.updateE(emp);
		out.print(result);
		out.flush();
		out.close();
	}

	private void addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String employeeName = request.getParameter("employeeName");
		
		String EmployeeGender = request.getParameter("employeeGender");
		
		int PositionID = Integer.parseInt(request.getParameter("positionName"));
		System.out.println(PositionID);
		int DepartmentID = Integer.parseInt(request.getParameter("departmentName"));
		String CardNumber = request.getParameter("cardNumber");
		String EmployeeState = request.getParameter("employeeState");
		String EmployeeMemo = request.getParameter("employeeMemo");
		Employee emp = new Employee(employeeName,EmployeeGender,PositionID,DepartmentID,CardNumber,EmployeeState,EmployeeMemo);
		boolean result = biz.addE(emp);
		out.print(result);
		out.flush();
		out.close();
	}

	private void queryAllEmployees(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		int currentPageIndex = Integer.parseInt(page)- 1;
		int pageSize = Integer.parseInt(rows);
		
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		Employee employee = new Employee();
		employee.setDepartmentID( 
				(request.getParameter("departmentID") == null
				|| request.getParameter("departmentID").equals("")
				|| request.getParameter("departmentID").equals("全部"))
					== true ? 0 : Integer.parseInt(request.getParameter("departmentID"))
				);
			if( request.getParameter("employeeName") != null 
					&& !request.getParameter("employeeName").equals(""))
			{
				employee.setEmployeeName(request.getParameter("employeeName"));
			}
			int total = biz.getCount(employee);
			PageUtil pager = new PageUtil(
					pageSize , currentPageIndex ,total 
					);
			
			List< Employee > list = biz.findAll(employee,pager);
			map.put("total", total);
			map.put("rows" , list);
			
			
			
			String jsonString = JSON.toJSONString(map);
			PrintWriter out = response.getWriter();
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
