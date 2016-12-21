package omss.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omss.domain.CaseResolution;
import omss.repository.CaseResolutionRepository;
import omss.util.OMSSPageUtil;

public class CaseResolutionController extends HttpServlet{
	
	CaseResolutionRepository caseResolutionRepo;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aptype=req.getParameter("aptype");
		System.out.println(" caseResolutions post is calling:"+aptype);
		
		List<CaseResolution> caseResolutions=new ArrayList<CaseResolution>();
		String msg=req.getParameter("patinetName");
		for (int i = 1; i < 6; i++) {
			if(!req.getParameter("medicen"+i).isEmpty()){
				CaseResolution caseResolution = new CaseResolution();
				caseResolution.setAppointid(Long.valueOf(req.getParameter("appointmentId")));
				
				caseResolution.setPatientName(req.getParameter("patinetName"));
				caseResolution.setSerialno( req.getParameter("s"+i));
				caseResolution.setMediciname(req.getParameter("medicen"+i));
				caseResolution.setCourseDays(req.getParameter("day"+i));
				caseResolution.setComments(req.getParameter("comment"+i));
				caseResolution.setDoctorName((String)req.getSession().getAttribute("username"));
				caseResolutions.add(caseResolution);
			}
		}

		System.out.println("case resolution size:"+caseResolutions.size());
		for (CaseResolution caseResolution : caseResolutions) {
			caseResolutionRepo.save(caseResolution);
		}
		req.setAttribute("msg", msg+" Prescription Submitted Successfully...");
		//req.setAttribute("type", aptype);
		RequestDispatcher dispatcher=req.getRequestDispatcher("appointmentController?type="+aptype);  
        dispatcher.forward(req,resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get is calling");
		
		String type=req.getParameter("type");
		
		String appointmentId=req.getParameter("appointmentId");
		String page;
		if(type!=null ){
			page=OMSSPageUtil.case_resolutionForm;
			req.setAttribute("appointmentId",appointmentId );//appointmentId
			req.setAttribute("patientName", req.getParameter("patientName"));
			req.setAttribute("type", req.getParameter("aptype"));
		}else{
		List<CaseResolution> caseResolutions=caseResolutionRepo.findByAppointmentId(appointmentId);
		req.setAttribute("caseResolutions", caseResolutions);
		page=OMSSPageUtil.patientReport;
		if(caseResolutions.size()>0){
			req.setAttribute("patientName",caseResolutions.get(0).getPatientName() );
			req.setAttribute("doctorName",caseResolutions.get(0).getDoctorName() );
			req.setAttribute("appointmentId",caseResolutions.get(0).getAppointid() );
		}
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher(page);  
        dispatcher.include(req,resp);
		
	}
}
