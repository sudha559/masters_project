package omss.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.util.OMSSPageUtil;

public class LogoffController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().removeAttribute("usertype");//,,,
		req.getSession().removeAttribute("email");
		req.getSession().removeAttribute("msg");
		req.getSession().removeAttribute("userid");
		req.getSession().removeAttribute("username");
		req.getSession().removeAttribute("type");
		req.getSession().removeAttribute("bhide");
		req.setAttribute("bhide", "true");//back,exit buttions hide when user logout
		
		RequestDispatcher rd=req.getRequestDispatcher(OMSSPageUtil.HOME_PAGE);  
		rd.include(req,resp);
	}
	
}
