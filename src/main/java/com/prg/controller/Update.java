package com.prg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prg.dao.UserDao;
import com.prg.dto.User;

@WebServlet("/update")
public class Update extends HttpServlet
{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User user=new User();
	user.setId(Integer.parseInt(req.getParameter("id")));
	user.setEmail(req.getParameter("email"));
	user.setMobile(Long.parseLong(req.getParameter("phone")));
	user.setName(req.getParameter("name"));
	user.setPassword(req.getParameter("password"));
	
	UserDao dao=new UserDao();
	dao.update(user);
	
	resp.getWriter().print("<h1>Updated Successfully</h1>");
	req.setAttribute("list", dao.fetchAll());
	req.getRequestDispatcher("Result.jsp").include(req, resp);
	

}
}