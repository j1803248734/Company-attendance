package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.AttendanceType;
import com.jiang.po.Note;
import com.jiang.po.Position;
import com.jiang.service.INoteBiz;
import com.jiang.service.Impl.NoteBizImpl;
import com.jiang.util.PageUtil;
@WebServlet("/NoteController/*")
public class NoteController extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doPost(request, response);
	}
	private INoteBiz  biz = new NoteBizImpl();
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String opt = request.getAttribute("opt").toString();
		switch (opt)
		{
		
		case "queryAllNotes":
			queryAllNotes(request, response);
			break;
		case "queryNoteByPK":
			queryNoteByPK(request, response);
			break;
		case "addNote":
			try {
				addNote(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "updateNote":
			try {
				updateNote(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "deleteNote":
			deleteNote(request, response);
			break;
		case "queryByCardNumber":
			queryByCardNumber(request,response);
			break;
		}
		
	}
	
		

	private void queryByCardNumber(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cardNumber = request.getParameter("cardNumber");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date attendanceDate = sdf.parse(request.getParameter("attendanceDate"));
			List<Note> list = biz.queryByCardNumber(cardNumber, attendanceDate);
			
			String jsonString = JSON.toJSONString(list);
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			out.flush();
			out.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}



	private void deleteNote(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int noteID =  Integer.parseInt( request.getParameter("noteID") );
		boolean result = biz.deleteNote(noteID);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}



	private void updateNote(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		Note note = new Note();
		
		note.setNoteID( Integer.parseInt( request.getParameter("noteID") )  );
		String employeeID = 
				request.getParameter("employeeName");
		
		employeeID = 
				employeeID.substring(employeeID.indexOf("(")+1, 
						employeeID.indexOf(")"));
		
		note.setEmployeeID( Integer.parseInt(employeeID));
		note.setDepartmentID( Integer.parseInt( request.getParameter("departmentID") )  );
		note.setNoteTypeID(
				Integer.parseInt(request.getParameter("noteTypeID")));
		note.setCause( request.getParameter("cause") );
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		note.setFillInTime(
				sdf.parse(request.getParameter("fillInTime"))
				);	
		
		
		note.setDirectorSign( request.getParameter("directorSign") );
		note.setAdministrationSign( request.getParameter("administrationSign") );
		note.setPresidentSign( request.getParameter("presidentSign") );
		note.setStartDate(
				sdf.parse( request.getParameter("startDate") )
				);
		note.setStartTime(request.getParameter("startTime"));
		note.setEndDate(
				sdf.parse(request.getParameter("endDate"))
				);
		note.setEndTime(request.getParameter("endTime"));
		note.setAdminID(2);
		note.setNoteMemo("");
		
		String operatorID = 
				request.getParameter("operatorName");
		operatorID = 
				operatorID.substring(operatorID.indexOf("(")+1, 
						operatorID.indexOf(")"));
		note.setOperatorID( Integer.parseInt(operatorID));
		
		
		
		boolean bln = biz.updateNote(note);
		HashMap<String , Boolean> map = 
				new HashMap<String , Boolean>();
		map.put("status", bln);
		
		String jsonString = JSON.toJSONString(map);
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();
		out.close();
		
	}



	private void addNote(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		Note note = new Note();
		
		String employeeID = 
				request.getParameter("employeeName");
		System.out.println(employeeID);
		employeeID = 
				employeeID.substring(employeeID.indexOf("(")+1, 
						employeeID.indexOf(")"));
		System.out.println(employeeID);
		note.setEmployeeID( Integer.parseInt(employeeID));
		note.setDepartmentID( Integer.parseInt( request.getParameter("departmentID") )  );
		note.setNoteTypeID(
				Integer.parseInt(request.getParameter("noteTypeID")));
		note.setCause( request.getParameter("cause") );
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		note.setFillInTime(
				sdf.parse(request.getParameter("fillInTime"))
				);	
		
		
		note.setDirectorSign( request.getParameter("directorSign") );
		note.setAdministrationSign( request.getParameter("administrationSign") );
		note.setPresidentSign( request.getParameter("presidentSign") );
		note.setStartDate(
				sdf.parse( request.getParameter("startDate") )
				);
		note.setStartTime(request.getParameter("startTime"));
		note.setEndDate(
				sdf.parse(request.getParameter("endDate"))
				);
		note.setEndTime(request.getParameter("endTime"));
		note.setAdminID(2);
		note.setNoteMemo("");
		
		String operatorID = 
				request.getParameter("operatorName");
		operatorID = 
				operatorID.substring(operatorID.indexOf("(")+1, 
						operatorID.indexOf(")"));
		note.setOperatorID( Integer.parseInt(operatorID));
		
		
		
		boolean bln = biz.addNote(note);
		HashMap<String , Boolean> map = 
				new HashMap<String , Boolean>();
		map.put("status", bln);
		
		String jsonString = JSON.toJSONString(map);
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();
		out.close();
		
	}



	private void queryNoteByPK(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int noteID = Integer.parseInt(request.getParameter("noteID"));
		
		PrintWriter out = response.getWriter();
		Note note = biz.queryNoteByPK(noteID);
		
		String jsonString  = JSON.toJSONString(note);
		out.print(jsonString);
		out.flush();
		out.close();
		
	}



	public void queryAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		int currentPageIndex = Integer.parseInt(page)- 1;
		int pageSize = Integer.parseInt(rows);

		
		HashMap<String,Object> map = 
					new HashMap<String,Object>();

		Note note = new Note();
		note.setAdminID(2);
		note.setDepartmentID( 
				(request.getParameter("departmentID") == null
				|| request.getParameter("departmentID").equals("")
				|| request.getParameter("departmentID").equals("全部"))
					== true ? 0 : Integer.parseInt(request.getParameter("departmentID"))
				);
		note.setNoteTypeID( 
				(request.getParameter("noteTypeID") == null
				|| request.getParameter("noteTypeID").equals("")
				|| request.getParameter("noteTypeID").equals("全部"))
					== true ? 0 : Integer.parseInt(request.getParameter("noteTypeID"))
				);
		
		if( request.getParameter("attendanceDate") 
				==null || request.getParameter("attendanceDate").equals("") ==true )
		{
			note.setStartDate(null);
		}else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date startDate = sdf.parse(request.getParameter("attendanceDate"));
				note.setStartDate(startDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if( request.getParameter("employeeName") != null 
				&& !request.getParameter("employeeName").equals(""))
		{
			note.setEmployeeName(request.getParameter("employeeName"));
		}
		
		int total = biz.getCount(note);
		PageUtil pager = new PageUtil(
				pageSize , currentPageIndex ,total 
				);
		
		List<Note> list =  biz.queryAllNotes(note , pager);
		
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
