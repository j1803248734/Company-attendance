package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.AttendanceRecord;
import com.jiang.po.Note;
import com.jiang.service.IAttendanceRecordBiz;
import com.jiang.service.Impl.AttendanceRecordBizImpl;
@WebServlet("/AttendanceRecordController/*")
public class AttendanceRecordController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AttendanceRecordController() {
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
	private IAttendanceRecordBiz biz = new AttendanceRecordBizImpl();
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String opt = request.getAttribute("opt").toString();
		switch (opt) {
		
		case "queryAttendanceRecords":
			try {
				queryAttendanceRecords(request , response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "batchAttendanceRecord":
			try {
				batchAttendanceRecord(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}

	

	private void batchAttendanceRecord(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date attendanceDate = sdf.parse(request.getParameter("attendanceDate"));
		
		String attendanceTime = request.getParameter("attendanceTime");
		
		//创建数组 存入每个人的信息   第一次见这种写法 收藏!   把要存入的信息依次建立数组
		String[] employeeIDs = request.getParameterValues("employeeID");
		String[] cardNumbers = request.getParameterValues("cardNumber");
		String[] attendanceTypes = request.getParameterValues("attendanceType");
		String[] noteIDs = request.getParameterValues("noteID");
		System.out.println("noteIDs");
		
		//循环遍历 数据依次填入 构建List集合 
		List<AttendanceRecord> list =  new ArrayList<AttendanceRecord>();
		for( int i=0 ; i< noteIDs.length;i++ )
		{
			AttendanceRecord atten = new AttendanceRecord();
			atten.setAdminID(2);
			atten.setEmployeeID(Integer.parseInt(employeeIDs[i]));
			atten.setCardNumber(cardNumbers[i]);
			atten.setAttendanceDate(attendanceDate);
			atten.setAttendanceTime(attendanceTime);
			atten.setDepartmentID(departmentID);
			atten.setNoteID(Integer.parseInt(noteIDs[i]));
			atten.setAttendanceType(Integer.parseInt(attendanceTypes[i]));
			list.add(atten);
			
		}
		boolean result = biz.batchAttendanceRecord(departmentID, attendanceDate, attendanceTime, list);
		String stringJSON = JSON.toJSONString(result);
		PrintWriter out = response.getWriter();
		out.print(stringJSON);
		out.flush();
		out.close();
	}



	
	
	private void queryAttendanceRecords(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date attendanceDate = sdf.parse(request.getParameter("attendanceDate"));
		
		String attendanceTime = request.getParameter("attendanceTime");
		
		
		
		List<AttendanceRecord> list = biz.queryAttendanceRecords(departmentID, 
					attendanceDate, 
					attendanceTime);
		
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
