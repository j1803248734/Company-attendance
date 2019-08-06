package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.AttendanceType;
import com.jiang.service.IAttendanceTypeBiz;
import com.jiang.service.Impl.AttendanceTypeBizImpl;
@WebServlet("/AttendanceTypeController/*")
public class AttendanceTypeController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AttendanceTypeController() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	private IAttendanceTypeBiz biz = new AttendanceTypeBizImpl();
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String opt = request.getAttribute("opt").toString();
		switch (opt)
		{
		case "queryAllAttendanceTypes":
			queryAllAttendanceTypes(request, response);
			break;
		case "queryAllLeaveTypes":
			queryAllLeaveTypes(request,response);
			break;
		case "queryAllTypes":
			queryAllTypes(request,response);
			break;
		
		}
	
	}

	private void queryAllTypes(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<AttendanceType> list = biz.queryAllTypes();
		String jsonString  = JSON.toJSONString(list);
		out.print(jsonString);
		out.flush();
		out.close();
		
	}

	private void queryAllLeaveTypes(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<AttendanceType> list = biz.queryAllLeaveTypes();
		String jsonString  = JSON.toJSONString(list);
		out.print(jsonString);
		out.flush();
		out.close();
		
	}

	private void queryAllAttendanceTypes(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
