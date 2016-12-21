package omss.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import omss.domain.CaseResolution;
import omss.repository.CaseResolutionRepository;

public class PdfController extends HttpServlet {
	
	CaseResolutionRepository caseResolutionRepo;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String path=request.getParameter("path");
	
    File file = new File(path);
    
    response.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
    response.setHeader("Content-Length", String.valueOf(file.length()));
    response.setHeader("Content-Disposition", "inline; filename=\""+file.getName()+"\"");
    
    Files.copy(file.toPath(), response.getOutputStream());
    
   }



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  try {
	             String appointmentId=req.getParameter("appointmentId");
	            Document document = new Document();
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            PdfWriter.getInstance(document, baos);
	            document.open();
	            
	            List<CaseResolution> caseResolutions=caseResolutionRepo.findByAppointmentId(appointmentId);
	    		req.setAttribute("caseResolutions", caseResolutions);
	    		String patientName="",doctorName="";
	    		if(caseResolutions.size()>0){
	    			patientName = caseResolutions.get(0).getPatientName() ;
	    			doctorName  = caseResolutions.get(0).getDoctorName() ;
	    		}
	    		
	            coverPageForReport(document, appointmentId, patientName,doctorName);
	            
	            addCaseResolution(document,caseResolutions);
	            
	            document.close();
	            String filename=appointmentId+"_"+patientName+".pdf";
	            resp.setHeader("Content-Disposition", "attachment; filename="+filename );
				// Set content type
				resp.setContentType("application/pdf");
				resp.setContentLength(baos.size());
				ServletOutputStream outputStream = resp.getOutputStream();
		 		baos.writeTo(outputStream);
		 		outputStream.flush();
	        }
	        catch(DocumentException e) {
	            throw new IOException(e.getMessage());
	        }
	}

	
	private void addCaseResolution(Document document, List<CaseResolution> caseResolutions) throws DocumentException {
		
		document.add(new Paragraph("\n\n\n"));
		float [] colw = {0.5f,2.4f,1.4f,4f};
		PdfPTable table = new PdfPTable(colw);
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		Font normal = new Font(FontFamily.TIMES_ROMAN, 8);
		Font BOLD = new Font(FontFamily.TIMES_ROMAN, 10,Font.BOLD, BaseColor.BLACK);
		PdfPCell pc1=new PdfPCell(new Phrase("S.No", BOLD));
		PdfPCell pc2=new PdfPCell(new Phrase("Medicine Name", BOLD));
		PdfPCell pc3=new PdfPCell(new Phrase("Course days", BOLD));
		PdfPCell pc4=new PdfPCell(new Phrase("Description", BOLD));
		
		pc1.setBorder(PdfPCell.NO_BORDER);
		pc2.setBorder(PdfPCell.NO_BORDER);
		pc3.setBorder(PdfPCell.NO_BORDER);
		pc4.setBorder(PdfPCell.NO_BORDER);
		
		table.addCell(pc1);
		table.addCell(pc2);
		table.addCell(pc3);
		table.addCell(pc4);
		 
		 
		 
			for (CaseResolution caseResolution : caseResolutions) {
		 	
				PdfPCell cell1 = new PdfPCell(new Phrase(caseResolution.getSerialno(), normal));
				PdfPCell cell2 = new PdfPCell(new Phrase(caseResolution.getMediciname(),normal));
				PdfPCell cell3 = new PdfPCell(new Phrase(caseResolution.getCourseDays(),normal));
				PdfPCell cell4 = new PdfPCell(new Phrase(caseResolution.getComments(),normal));
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell2.setBorder(PdfPCell.NO_BORDER);
				cell3.setBorder(PdfPCell.NO_BORDER);
				cell4.setBorder(PdfPCell.NO_BORDER);
				
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
				} 
			document.add(table);	
	}
			
		



	public void coverPageForReport(Document document,String id,String name, String doctorName)throws DocumentException{
		 Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLDITALIC);
		Paragraph p1=new Paragraph();
	      Paragraph p2=new Paragraph();
	      Paragraph p3=new Paragraph();
	      Paragraph p4=new Paragraph();
	      
	      p1.setSpacingBefore(130);
	      p1.setFont(catFont);
	      p2.setFont(catFont);
	      p1.add("Non Emergency Medical Service System");
	      p1.setAlignment(Element.ALIGN_CENTER);
	      p2.setSpacingBefore(50);
	      p2.add("Report");
	      p2.setAlignment(Element.ALIGN_CENTER);
	      p3.setSpacingBefore(40);
	      p3.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
	      p3.setAlignment(Element.ALIGN_CENTER);
	      p3.add("Appointment ID:	"+id+"                  Patient Name:"+name);
	      
	      p4.setSpacingBefore(10);
	      p4.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
	      p4.setAlignment(Element.ALIGN_CENTER);
	      p4.add("Doctor Name:	"+doctorName);
	      
	      document.add(p1);
	      document.add(p2);
	      document.add(p3);
	      document.add(p4);
	}
}