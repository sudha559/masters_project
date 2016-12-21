package omss.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.domain.Appointment;
import omss.domain.Doctor;
import omss.domain.Feedback;
import omss.repository.AppointmentRepository;
import omss.repository.DoctorRepository;
import omss.repository.FeedBackRepository;
import omss.util.OMSSPageUtil;

public class FeedBackController extends HttpServlet{

	FeedBackRepository feedBackRepository;
	DoctorRepository doctorRepository;
	AppointmentRepository appointmentRepository;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String doctorName=(String) req.getSession().getAttribute("username");
		Long doctorid=(Long) req.getSession().getAttribute("userid");
		//type=doctorFeedBack
		String type=req.getParameter("type");
		System.out.println("type:"+type);
		if(type!=null && type.equals("doctorFeedBack")){
			List<Feedback> feedbacks=feedBackRepository.findAllByDoctor(doctorid);
			req.setAttribute("feedBacks", feedbacks);
			req.setAttribute("role", "doctor");
			RequestDispatcher rd=req.getRequestDispatcher(OMSSPageUtil.doctors_feedBackPages);  
	        rd.include(req,resp);
			return;
		}else if(type!=null && type.equals("historyFeedBack")){
			List<Feedback> feedbacks=feedBackRepository.findAll();
			req.setAttribute("feedBacks", feedbacks);
			req.setAttribute("role", "patient");
			RequestDispatcher rd=req.getRequestDispatcher(OMSSPageUtil.doctors_feedBackPages);  
	        rd.include(req,resp);
			return;
		}
		
		
		String patientName=(String) req.getSession().getAttribute("username");
		Long userid=(Long) req.getSession().getAttribute("userid");
		System.out.println("FeedBack Get is calling:"+patientName+"-"+userid);
		List<Appointment> a=appointmentRepository.findAppointmentsByPatient(userid);
		List<Doctor> doctors=new ArrayList<Doctor>();
		Map<Long,Long> map=new HashMap();
		
		for (Appointment appointment : a) {
			
			Doctor d=doctorRepository.findById(""+appointment.getDoctorId());
			if(d!=null){
				if(!map.containsKey(d.getDoctorId())){
					map.put(d.getDoctorId(), d.getDoctorId());
					doctors.add(d);	
				}
				
			}
		}
		req.setAttribute("doctors", doctors);
		String page=OMSSPageUtil.feedbackForm;
		RequestDispatcher rd=req.getRequestDispatcher(page);  
        rd.include(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FeedBack post is calling");
		String doctorName=req.getParameter("doctorName");
		long doctorId=Long.valueOf(req.getParameter("doctorId"));
		String rating=req.getParameter("rating");
		String review=req.getParameter("review");
		String patientName=(String) req.getSession().getAttribute("username");
		Doctor doctor=doctorRepository.findAccountDetails(doctorId);
		
		Feedback feedback=new Feedback();
		feedback.setDoctorId(doctorId);
		feedback.setDoctorName(doctor.getName());
		feedback.setPatientName(patientName);
		feedback.setRating(rating);
		feedback.setReview(review);
		
		feedBackRepository.save(feedback);
		req.setAttribute("msg", "Feedback Successfully Submitted");
		RequestDispatcher rd=req.getRequestDispatcher(OMSSPageUtil.PAtientHOME_PAGE);  
        rd.include(req,resp);
		
	}

}
