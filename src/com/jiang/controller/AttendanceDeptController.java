package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.Admin;
import com.jiang.po.AttendanceRecord;
import com.jiang.po.Employee;
import com.jiang.service.AttendanceDeptBiz;
import com.jiang.service.Impl.AttendanceDeptBizImpl;
@WebServlet("/AttendanceDeptController/*")
public class AttendanceDeptController extends HttpServlet {
	private AttendanceDeptBiz biz = new AttendanceDeptBizImpl();
	/**
	 * Constructor of the object.
	 */
	public AttendanceDeptController() {
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
		case "queryDepartmentCompreStatistics":
			queryDepartmentCompreStatistics(request, response);
			break;
		}
	}

private void queryDepartmentCompreStatistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee employee = new Employee();
		
	String radiotf = request.getParameter("radiotf");
	if("true".equals(radiotf)){
		if( request.getParameter("attendanceDate") 
				==null || request.getParameter("attendanceDate").equals("") ==true )
		{
			employee.setStartDate(null);
		}else
		{
			int sel1 = Integer.parseInt(request.getParameter("sel1"));
			int sel2 = Integer.parseInt(request.getParameter("sel2"));
			employee.setSel1(sel1);
			employee.setSel2(sel2);
		}
	}else if("false".equals(radiotf))
	{
		if( request.getParameter("startTime") 
				==null || request.getParameter("startTime").equals("") ==true )
		{
			employee.setStartDate(null);
		}else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date startDate = sdf.parse(request.getParameter("startTime"));
				employee.setStartDate(startDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if( request.getParameter("endTime") 
				==null || request.getParameter("endTime").equals("") ==true )
		{
			employee.setStartDate(null);
		}else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date endDate = sdf.parse(request.getParameter("endTime"));
				employee.setEndDate(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	employee.setDepartmentID( 
			(request.getParameter("departmentID") == null
			|| request.getParameter("departmentID").equals("")
			|| request.getParameter("departmentID").equals("全部"))
				== true ? 0 : Integer.parseInt(request.getParameter("departmentID"))
			);
	
	
		List<Employee>  list = biz.queryDepartmentCompreStatistics(employee);
		String jsonString = JSON.toJSONString(list);
		
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
