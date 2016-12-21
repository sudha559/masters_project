package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omss.domain.Doctor;

public class DoctorRepository {

	public static Doctor createDoctor(Doctor doctor) {

		try{  
		  
		Connection con=JdbcConnection.getJDBC_connection();  
		      
		PreparedStatement ps=con.prepareStatement( "INSERT INTO doctor (firstName,lastName,gender,email,password,hospitalName,experience,specializationId,state,city,zipcode) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, doctor.firstName);
			ps.setString(2, doctor.lastName);
			ps.setString(3, doctor.gender);
			ps.setString(4, doctor.email.toLowerCase());
			ps.setString(5, doctor.password);
			ps.setString(6,doctor.hospitalName);
			ps.setString(7,doctor.experience);
			ps.setLong(8,doctor.specializationId);
			ps.setString(9, doctor.state);
			ps.setString(10, doctor.city);
			ps.setString(11, doctor.zipcode);
		
			 ps.execute();
			 
			 PreparedStatement ps1 = con.prepareStatement("select * from doctor where email='"+doctor.email.toLowerCase()+"'");
				ResultSet rs = ps1.executeQuery();
				while (rs.next()) {
					Doctor doc=new Doctor();
					
					doc.setDoctorId(rs.getLong("doctorId"));
					doc.setFirstName(rs.getString("firstName"));
					doc.setLastName(rs.getString("lastName"));
					doc.setEmail(rs.getString("email"));
					doc.setExperience(rs.getString("experience"));
					doc.setPassword(rs.getString("password"));
					doc.setHospitalName(rs.getString("hospitalName"));
					doc.setGender(rs.getString("gender"));
					doc.setSpecializationId(rs.getLong("specializationId"));
					
					return doc;
				}	
		
		}catch(Exception e){
			e.printStackTrace();
		}  
		return null;  
			
	}

	public static Doctor validateCredentials(String email, String password) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
			PreparedStatement ps = con.prepareStatement("select * from doctor where email=? and password=?");
			ps.setString(1,email );
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doctor=new Doctor();
				
				doctor.setDoctorId(rs.getLong("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setEmail(rs.getString("email"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setPassword(rs.getString("password"));
				doctor.setHospitalName(rs.getString("hospitalName"));
				doctor.setGender(rs.getString("gender"));
				doctor.setSpecializationId(rs.getLong("specializationId"));
				
				return doctor;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	public static List<Doctor> findAllDoctors() {
		List<Doctor> doctors=new ArrayList<>();
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from doctor");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Doctor doctor=new Doctor();
				
				doctor.setDoctorId(rs.getLong("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setEmail(rs.getString("email"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setPassword(rs.getString("password"));
				doctor.setHospitalName(rs.getString("hospitalName"));
				doctor.setGender(rs.getString("gender"));
				doctor.setSpecializationId(rs.getLong("specializationId"));
				
				doctors.add(doctor);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return doctors;
	}

	public static Doctor findById(String id) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
			PreparedStatement ps = con.prepareStatement("select * from doctor where doctorId="+id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doctor=new Doctor();
				
				doctor.setDoctorId(rs.getLong("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setEmail(rs.getString("email"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setPassword(rs.getString("password"));
				doctor.setHospitalName(rs.getString("hospitalName"));
				doctor.setGender(rs.getString("gender"));
				doctor.setSpecializationId(rs.getLong("specializationId"));
				
				return doctor;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	public static List<Doctor> findBySpecilization(String spe) {
		List<Doctor> doctors=new ArrayList<>();
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from doctor where specializationId="+spe);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Doctor doctor=new Doctor();
				
				doctor.setDoctorId(rs.getLong("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setEmail(rs.getString("email"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setPassword(rs.getString("password"));
				doctor.setHospitalName(rs.getString("hospitalName"));
				doctor.setGender(rs.getString("gender"));
				doctor.setSpecializationId(rs.getLong("specializationId"));
				
				doctors.add(doctor);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return doctors;
	}

	public static Doctor findAccountDetails(long doctorid) {
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from doctor where doctorid="+doctorid);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Doctor doctor=new Doctor();
				
				doctor.setDoctorId(rs.getLong("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setEmail(rs.getString("email"));
				doctor.setExperience(rs.getString("experience"));
				doctor.setPassword(rs.getString("password"));
				doctor.setHospitalName(rs.getString("hospitalName"));
				doctor.setGender(rs.getString("gender"));
				doctor.setSpecializationId(rs.getLong("specializationId"));
				
				return doctor;
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return null;
	}

	public static void delete(String userId) throws SQLException {
		
			   String q="delete from doctor where doctorId='"+userId+"';";
			   Connection connection=JdbcConnection.getJDBC_connection();
			   Statement statement = connection.createStatement();
			    statement.execute(q);//executeQuery(q);
			    	
	}

	public static boolean isEmailAvilable(String email) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
			PreparedStatement ps = con.prepareStatement("select * from doctor where email='"+email+"'");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	public static void updateDoctor(long doctorId, String psw) throws SQLException {

		String q="update doctor d set password='"+psw+"' where doctorid='"+doctorId+"';";
		   System.out.println("Query:"+q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);
			
	}

}
