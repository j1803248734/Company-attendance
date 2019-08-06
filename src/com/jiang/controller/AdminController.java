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
import com.jiang.po.Admin;
import com.jiang.po.AdminPopeDom;
import com.jiang.po.Department;
import com.jiang.service.IAdminBiz;
import com.jiang.service.Impl.AdminBizImpl;
import com.jiang.util.PageUtil;
@WebServlet("/AdminController/*")
public class AdminController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminController() {
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
	private IAdminBiz biz = new AdminBizImpl();
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
		case "findAll":
			findAll(request, response);
			break;
		case "findAllU":
			findAllU(request,response);
			break;
		case "deleteA":
			deleteA(request,response);
			break;
		case "updateA":
			updateA(request,response);
			break;
		}
	}

	private void updateA(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int departmentID = Integer.parseInt(request.getParameter("departmentID"));
		
		int popedomID = Integer.parseInt(request.getParameter("popedomID"));
		
		AdminPopeDom ap = new AdminPopeDom();
		ap.setTwoDID(departmentID);
		ap.setPopedomID(popedomID);
		boolean result = biz.updateA(ap);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	private void deleteA(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int popedomID = Integer.parseInt(request.getParameter("popedomID"));
		
		boolean result = biz.deleteA(popedomID);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int currentPageIndex = Integer.parseInt(page)- 1;
		int pageSize = Integer.parseInt(rows);
		HashMap<String,Object> map = new HashMap<String,Object>();
		Admin admin = new Admin();
		String adminAccount = request.getParameter("adminAccount");
		admin.setAdminAccount(adminAccount);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int total = biz.getCount();
		PageUtil pager = new PageUtil(
				pageSize , currentPageIndex ,total 
				);
		List<Admin> list = biz.findAll(pager,admin);
		map.put("total", total);
		map.put("rows" , list);
		String jsonString  = JSON.toJSONString(map);
		out.print(jsonString);
		out.flush();
		out.close();
	}
	private void findAllU(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Admin> list = biz.findAll();
	
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
