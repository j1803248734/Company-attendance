package com.jiang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.jiang.po.Admin;
import com.jiang.service.IndexBiz;
import com.jiang.service.Impl.IndexBizImpl;
@WebServlet("/IndexController/*")
public class IndexController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexController() {
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
	
	private IndexBiz biz = new IndexBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String opt = request.getAttribute("opt").toString();
		switch (opt)
		{
		case "findTF":
			findTF(request, response);
			break;
		case "loginA":
			loginA(request,response);
			break;
		case "update":
			update(request,response);
			break;
		}
		
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String adminAccount = request.getParameter("adminAccount");
		String adminPwd = request.getParameter("adminPwd");
		Admin admin = new Admin();
		admin.setAdminID(adminID);
		admin.setAdminAccount(adminAccount);
		admin.setAdminPwd(adminPwd);
		boolean result = biz.update(admin);
		
		PrintWriter out = response.getWriter();
		String jsonString = JSON.toJSONString(result);
		out.print(jsonString);
		out.flush();
		out.close();
	}

	int adminID = 0;
	private void loginA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		Admin admin = biz.findAll(adminID);
		
		String jsonString = JSON.toJSONString(admin);
		out.print(jsonString);
		out.flush();
		out.close();
	}

	private void findTF(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");	
		String password = request.getParameter("password");
		
		Admin admin = biz.findAll(username,password);
		
		adminID = admin.getAdminID();	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String jsonString = JSON.toJSONString(admin);
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
