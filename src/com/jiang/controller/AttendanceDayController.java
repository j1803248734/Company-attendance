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
import com.jiang.po.AttendanceRecord;
import com.jiang.service.AttendanceDayBiz;
import com.jiang.service.Impl.AttendanceDayBizImpl;
@WebServlet("/AttendanceDayController/*")
public class AttendanceDayController extends HttpServlet {
	private AttendanceDayBiz biz = new AttendanceDayBizImpl();
	/**
	 * Constructor of the object.
	 */
	public AttendanceDayController() {
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

		doPost(request,response);
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String opt = request.getAttribute("opt").toString();
		switch (opt)
		{
		case "findByDay":
			try {
				findByDay(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	private void findByDay(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date attendanceDate = sdf.parse(request.getParameter("attendanceDate"));
		
		System.out.println(attendanceDate);
		
		String  attendanceTime = new String(request.getParameter("attendanceTime").getBytes("iso-8859-1"),"utf-8");
		System.out.println(attendanceTime);
		List<AttendanceRecord> attendanceDay = biz.findByDay(attendanceDate, attendanceTime);
		PrintWriter out = response.getWriter();
		String stringJSON = JSON.toJSONString(attendanceDay);
		out.print(stringJSON);
		System.out.println(stringJSON);
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
