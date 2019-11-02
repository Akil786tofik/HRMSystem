package com.servlet.classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.AdminLogin;
import com.hrms.dao.Admin_Login;

/**
 * Servlet implementation class AdminLoginone
 */
@WebServlet("/AdminLoginone")
public class AdminLoginone extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		Admin_Login admin_login=new Admin_Login();
   		AdminLogin adminlogin=new AdminLogin();
		adminlogin.setAdmin_name(request.getParameter("name"));
		adminlogin.setAdmin_password(request.getParameter("password"));
		adminlogin.setId(Integer.parseInt(request.getParameter("id")));
		boolean b=admin_login.insertRecord(adminlogin);	
		if(b==true)
		{
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}
	}
}
