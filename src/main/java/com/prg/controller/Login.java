package com.prg.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prg.dao.UserDao;
import com.prg.dto.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emph=req.getParameter("emph");
		String password=req.getParameter("pwd");
		
		UserDao dao=new UserDao();
		RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
		
		try {
			long mobile=Long.parseLong(emph);
			User user=dao.login(mobile);
			if(user==null)
			{
				resp.getWriter().print("<h1>Incorrect Mobile Number</h1>");
				dispatcher.include(req, resp);
			}
			else 
			{
				if(user.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>Login Success</h1>");
					req.setAttribute("list", dao.fetchAll());
					req.getRequestDispatcher("Result.jsp").include(req, resp);
				}
				else {
					resp.getWriter().print("<h1>Incorrect Password</h1>");
					dispatcher.include(req, resp);
				}
			}
		}
		catch (NumberFormatException e) {
			String email=emph;
			User user=dao.login(email);
			if(user==null)
			{
				resp.getWriter().print("<h1>Incorrect Email</h1>");
				dispatcher.include(req, resp);
			}
			else 
			{
				if(user.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>Login Success</h1>");
					req.setAttribute("list", dao.fetchAll());
					req.getRequestDispatcher("Result.jsp").include(req, resp);
				}
				else {
					resp.getWriter().print("<h1>Incorrect Password</h1>");
					dispatcher.include(req, resp);
				}
			}
		}
	}
	
}

