package omss.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.domain.Doctor;
import omss.domain.Patient;
import omss.repository.DoctorRepository;
import omss.repository.PatientRepository;
import omss.repository.SpecializationRepository;
import omss.util.OMSSPageUtil;

public class RegistrationController extends HttpServlet{
	
	PatientRepository patientRepository;
	DoctorRepository doctorRepository;
	 SpecializationRepository  specializationRepository;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String patient=req.getParameter("patient");
		String page=OMSSPageUtil.Registration;
		System.out.println("patient:"+patient);
		if(patient==null){
			req.setAttribute("type", "doctor");
			req.setAttribute("specializations", specializationRepository.getAll());
		}else{
			req.setAttribute("type", "patient");
		}
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(page);  
        dispatcher.include(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type=req.getParameter("type");
		System.out.println("type:"+type);
		
		String page=OMSSPageUtil.WELCOME_PAGE;
		
		if(type.equals("doctor")){
			Doctor doctor=new Doctor();
			doctor.lastName=req.getParameter("lastName");
			doctor.firstName=req.getParameter("firstName");
			doctor.gender=req.getParameter("gender");
			doctor.email=req.getParameter("email");
			doctor.password=req.getParameter("password");
			doctor.hospitalName=req.getParameter("hospitalName");
			doctor.experience=req.getParameter("experience");
			doctor.specializationId=Long.valueOf(req.getParameter("specializationId"));
			
			doctor.city=req.getParameter("city");
			doctor.state=req.getParameter("state");
			doctor.zipcode=req.getParameter("zipcode");
			
			if(!doctorRepository.isEmailAvilable(doctor.email.toLowerCase())){
				Doctor doctor1= doctorRepository.createDoctor(doctor);
				req.setAttribute("msg","Successfully Registerd !!  Dr."+ doctor.firstName+" "+doctor.lastName);
				//page=OMSSPageUtil.doctorHOME_PAGE;
				System.out.println("doctor1:"+doctor1+",id:"+doctor1.getDoctorId());
				req.getSession().setAttribute("email", doctor.email);
				req.getSession().setAttribute("usertype", "doctor");
				req.getSession().setAttribute("userid", doctor1.getDoctorId());
				req.getSession().setAttribute("username", doctor.getFirstName()+" "+doctor.getLastName());
				req.setAttribute("link", "doctorindex.jsp");
			}else{
				req.setAttribute("msg", "Email alrady Exist, Please try another.");
				req.setAttribute("doctor", doctor);
				req.setAttribute("specializations", specializationRepository.getAll());
				page=OMSSPageUtil.doctor_Reg;
			}
		}else if(type.equals("patient")){
			
			Patient p=new Patient();
			p.lastName=req.getParameter("lastName");
			p.firstName=req.getParameter("firstName");
			p.gender=req.getParameter("gender");
			p.email=req.getParameter("email");
			p.password=req.getParameter("password");
			p.city=req.getParameter("city");
			p.state=req.getParameter("state");
			p.zipcode=req.getParameter("zipcode");
			p.diabetes=req.getParameter("diabetes");
			
			p.bloodGroup=req.getParameter("bloodgroup");
			p.bmi=req.getParameter("bmi");
			System.out.println(p.bloodGroup+" "+p.bmi);
			if(!patientRepository.isEmailAvilable(p.email.toLowerCase())){
				Patient patient=patientRepository.createPatient(p);
				req.setAttribute("msg", p.firstName+" "+p.lastName);
				//page=OMSSPageUtil.PAtientHOME_PAGE;
				req.setAttribute("link", "patientindex.jsp");
				req.getSession().setAttribute("email", p.email.toLowerCase());
				req.getSession().setAttribute("usertype", "patient");
				req.setAttribute("msg", "Successfully Registered");

				req.getSession().setAttribute("userid", patient.getPatientId());
				req.getSession().setAttribute("username", patient.getFirstName()+" "+patient.getLastName());
			}else{
				req.setAttribute("msg", "Email alrady Exist, Please try another.");
				req.setAttribute("patient", p);
				page=OMSSPageUtil.patient_Reg;
			}
		}
//		getServletContext().getRequestDispatcher(OMSSUtil.HOME_PAGE).forward(req,resp);
		 RequestDispatcher dispatcher=req.getRequestDispatcher(page);  
         dispatcher.include(req,resp); 
	}

}
