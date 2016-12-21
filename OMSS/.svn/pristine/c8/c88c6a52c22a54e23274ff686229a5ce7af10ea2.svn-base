package omss.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.util.OMSSPageUtil;

public class AboutUsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usertype=(String) req.getSession().getAttribute("usertype");
		System.out.println("usertype:"+usertype);
		req.setAttribute("type", usertype);
		RequestDispatcher rd=req.getRequestDispatcher(OMSSPageUtil.aboutUs);  
		rd.include(req,resp);
	}
	
}
