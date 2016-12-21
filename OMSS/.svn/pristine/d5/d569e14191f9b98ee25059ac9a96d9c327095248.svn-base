package omss.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.domain.Admin;
import omss.repository.AdminRepository;
import omss.util.OMSSPageUtil;

public class AdminController extends HttpServlet{
	
	AdminRepository adminRepository;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type=req.getParameter("type");
		System.out.println("tye:"+type);
		 if(type!=null && type.equals("accountDetails")){
			 long adminId=(Long)req.getSession().getAttribute("userid");
			 String username=(String)req.getSession().getAttribute("username");
			 
			 Admin admin=adminRepository.findById(adminId);
			 System.out.println("d"+admin);
			 if(admin!=null){
				 req.setAttribute("admin", admin);
				 req.setAttribute("type", "admin");
					RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.ACCOUNT);  
			        dispatcher.include(req,resp);
			 }
		 }
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("adminController post is calling");
		String type= req.getParameter("type");//changePsw
		long patient=(Long)req.getSession().getAttribute("userid");
		if(type!=null && type.equals("changePsw")){
			String psw = req.getParameter("password");
			try {
				adminRepository.updateUser(patient,psw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("msg", "Password Updated Successfully");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.adminHOME_PAGE);  
        dispatcher.include(req,resp);
		
	
	}

}
