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
import com.jiang.po.Position;
import com.jiang.service.IPositionBiz;
import com.jiang.service.Impl.PositionBizImpl;
@WebServlet("/PositionController/*")
public class PositionController extends HttpServlet {
	private IPositionBiz biz = new PositionBizImpl();
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
		case "queryAllPositions":
			queryAllPositions(request, response);
			break;
		case "addPosition":
			addPosition(request,response);
			break;
		case "updatePosition":
			updatePosition(request,response);
			break;
		case "deletePosition":
			deletePosition(request,response);
			break;
		case "queryPosition" :
			queryPosition(request,response);
		}
		
		
	}
	private void deletePosition(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException  {
		
		int positionID = Integer.parseInt(request.getParameter("positionID"));
		
		boolean result = biz.deleteP(positionID);
		String msg = "";
		if(result)
		{
			msg = "操作成功";
		}else{
			msg = "操作失败";
		}
	}

	private void updatePosition(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String positionName = request.getParameter("positionName");
		
		
		int positionID = Integer.parseInt(request.getParameter("positionID"));
		
		
		Position position = new Position(positionID,positionName);
		
		boolean result = biz.updateP(position);
		
		String msg = "";
		if(result)
		{
			msg = "操作成功";
		}else{
			msg = "操作失败";
		}
	
	}

	private void addPosition(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String positionName = request.getParameter("positionName");
		
		Position position = new Position(positionName);
		boolean result = biz.addP(position);
		String msg = "";
		if(result)
		{
			msg = "操作成功";
		}else{
			msg = "操作失败";
		}
		
			
	}

	public void queryAllPositions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List< Position > list = biz.findAll();
		
		String jsonString  = JSON.toJSONString(list);
		out.print(jsonString);
		out.flush();
		out.close();
	}
	public void queryPosition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int positionID = Integer.parseInt(request.getParameter("positionID"));
		PrintWriter out = response.getWriter();
		 Position  position =  biz.findById(positionID);
		
		String jsonString  = JSON.toJSONString(position);
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
