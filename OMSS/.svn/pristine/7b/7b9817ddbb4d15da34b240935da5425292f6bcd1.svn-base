package omss.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.domain.Patient;
import omss.repository.PatientRepository;
import omss.util.OMSSPageUtil;

public class PatientController extends HttpServlet{

	PatientRepository patientRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type=req.getParameter("type");
		System.out.println("tye:"+type);
		 if(type!=null && type.equals("accountDetails")){
			 long patient=(Long)req.getSession().getAttribute("userid");
			 String username=(String)req.getSession().getAttribute("username");
			 
			 Patient d=patientRepository.findById(patient);
			 System.out.println("d:"+d);
			 if(d!=null){
				 req.setAttribute("patient", d);
				 req.setAttribute("type", "patient");
					RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.ACCOUNT);  
			        dispatcher.include(req,resp);
			 }
		 }else{
			System.out.println("PatientController doGet is calling");
			List<Patient> patients=patientRepository.findAllPatients();
			req.setAttribute("patients", patients);
	//		getServletContext().getRequestDispatcher(OMSSPageUtil.patientList).include(req, resp);
			 RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.patientList);  
	         dispatcher.include(req,resp);
		 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PatientController doPost is calling");
		String type= req.getParameter("type");//changePsw
		long patient=(Long)req.getSession().getAttribute("userid");
		if(type!=null && type.equals("changePsw")){
			String psw = req.getParameter("password");
			try {
				patientRepository.updatePatient(patient,psw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("msg", "Password Updated Successfully");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher(OMSSPageUtil.PAtientHOME_PAGE);  
        dispatcher.include(req,resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PatientController doDelete is calling");
	}
}
