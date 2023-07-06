package com.prg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prg.dao.UserDao;

public class Delete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao();
		dao.delete(id);
		
		req.setAttribute("list", dao.fetchAll());
		res.getWriter().print("<h1>Deleted Successfully</h1>");
		req.getRequestDispatcher("Result.jsp").include(req, res);
	}
}
