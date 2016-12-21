package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import omss.domain.Feedback;

public class FeedBackRepository {

	public static boolean save(Feedback feedback) {
		try{  
			  
			Connection con=JdbcConnection.getJDBC_connection();  
			      
			PreparedStatement ps=con.prepareStatement( "INSERT INTO feedback (doctorid,doctorName,patientName,rating,review) "
	                + "VALUES (?,?,?,?,?)");
			
				ps.setLong(1, feedback.getDoctorId());
				ps.setString(2,feedback.getDoctorName());
				ps.setString(3, feedback.getPatientName());
				ps.setString(4, feedback.getRating());
				ps.setString(5, feedback.getReview());
				
			
				return ps.execute();
			
			}catch(Exception e){
				e.printStackTrace();
			}  
			return false; 		
	}

	public static List<Feedback> findAllByDoctor(Long doctorid) {
		//SELECT * FROM feedback f where doctorId=17;

		List<Feedback> Feedbacks=new ArrayList<>();
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("SELECT * FROM feedback f where doctorId="+doctorid);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Feedback feedback=new Feedback();
				feedback.setFeedbackId(rs.getLong("feedbackId"));
				feedback.setDoctorId(rs.getLong("doctorId"));
				feedback.setPatientName(rs.getString("patientName"));
				feedback.setRating(rs.getString("rating"));
				feedback.setReview(rs.getString("review"));
				feedback.setDoctorName(rs.getString("doctorName"));
				
				Feedbacks.add(feedback);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return Feedbacks;
	
	}

	public static List<Feedback> findAll() {
		//SELECT * FROM feedback f where doctorId=17;

		List<Feedback> Feedbacks=new ArrayList<>();
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("SELECT * FROM feedback f ");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Feedback feedback=new Feedback();
				feedback.setFeedbackId(rs.getLong("feedbackId"));
				feedback.setDoctorId(rs.getLong("doctorId"));
				feedback.setPatientName(rs.getString("patientName"));
				feedback.setRating(rs.getString("rating"));
				feedback.setReview(rs.getString("review"));
				feedback.setDoctorName(rs.getString("doctorName"));
				
				Feedbacks.add(feedback);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return Feedbacks;
	
	}

}
