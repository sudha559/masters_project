package omss.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import omss.domain.Doctor;
import omss.domain.Specialization;
import omss.repository.DoctorRepository;
import omss.repository.SpecializationRepository;
import omss.util.OMSSPageUtil;

public class DoctorController extends HttpServlet{

	DoctorRepository doctorRepository;
	SpecializationRepository specializationRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String spe = req.getParameter("spe");
		 
		 System.out.println("doctor controller get is calling:"+spe);
		 if(spe!=null){
			 List<Doctor> doctors=doctorRepository.findBySpecilization(spe);
			 String json = new Gson().toJson(doctors);
			 System.out.println("json:"+json);
			 //json:[{"doctorId":3,"firstName":"shiva","lastName":"Reddy","gender":"male","email":"reddy@gmail.com","experience":"1","hospitalName":"appolo","password":"123456","specializationId":1},{"doctorId":4,"firstName":"sai","lastName":"nukes","gender":"male","email":"devarapallis@mail.sacredheart.edu","experience":"4","hospitalName":"appolo","password":"password","specializationId":1},{"doctorId":5,"firstName":"venu","lastName":"kuthala","gender":"male","email":"venuk@gmail.com","experience":"1","hospitalName":"xxxxxxxxxxxx","password":"123","specializationId":1},{"doctorId":6,"firstName":"reddy","lastName":"shiva","gender":"male","email":"uhduvhc@gmail.com","experience":"1","hospitalName":"uisbduifbd","password":"oivhsfdoin","specializationId":1},{"doctorId":7,"firstName":"shiva","lastName":"Reddy","gender":"male","email":"naughtynishanth333@gmail.com","experience":"3","hospitalName":"appolo","password":"sai","specializationId":1},{"doctorId":8,"firstName":"chaithu","lastName":"rao","gender":"male","email":"chaithu@gmail.com","experience":"3","hospitalName":"obc","password":"1234","specializationId":3}]

			 resp.setContentType("application/json");
	         resp.getWriter().write(json);
		 }else{
			 String type=req.getParameter("type");//accountDetails
			 System.out.println("doctor controller get is calling type:"+type);
			 if(type!=null && type.equals("accountDetails")){
				 long doctorid=(Long)req.getSession().getAttribute("userid");
				 String username=(String)req.getSession().getAttribute("username");
				 
				 Doctor d=doctorRepository.findAccountDetails(doctorid);
				 System.out.println("doctor:"+d+", doctorid:"+doctorid);
				 if(d!=null){
					 Specialization sp=specializationRepository.get(d.getSpecializationId());
					 d.setSpecializationName(sp.getSpecializationName());
					 req.setAttribute("doctor", d);
					 req.setAttribute("type", "doctor");
						RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.ACCOUNT);  
				        dispatcher.include(req,resp);
				        return;
				 }
			 }else {

					List<Doctor> doctors=doctorRepository.findAllDoctors();
					req.setAttribute("doctors", doctors);
					req.setAttribute("type", "doctor");
					RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.doctorsList);  
			        dispatcher.include(req,resp);
			 }
		 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doctorController post is calling");
		String type= req.getParameter("type");//changePsw
		long patient=(Long)req.getSession().getAttribute("userid");
		if(type!=null && type.equals("changePsw")){
			String psw = req.getParameter("password");
			try {
				doctorRepository.updateDoctor(patient,psw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("msg", "Password Updated Successfully");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.doctorHOME_PAGE);  
        dispatcher.include(req,resp);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
