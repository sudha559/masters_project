package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omss.domain.Patient;

public class PatientRepository {

	
	public static Patient createPatient(Patient p) {
		try{  
		  
		Connection con=JdbcConnection.getJDBC_connection();  
		      
		PreparedStatement ps=con.prepareStatement( "INSERT INTO patient (firstName,lastName,gender,email,password,bloodGroup,bmi,state,city,zipcode,diabetes) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, p.firstName);
		ps.setString(2, p.lastName);
		ps.setString(3, p.gender);
		ps.setString(4, p.email.toLowerCase());
		ps.setString(5, p.password);
		ps.setString(6, p.bloodGroup);
		ps.setString(7, p.bmi);
		ps.setString(8, p.state);
		ps.setString(9, p.city);
		ps.setString(10, p.zipcode);
		ps.setString(11, p.diabetes);
		
		ps.execute();
			PreparedStatement ps1 = con.prepareStatement("select * from patient where email='"+p.email.toLowerCase()+"'");
			ResultSet rs = ps1.executeQuery();
			
		 if(rs.next()){
			 Patient patient=new Patient();
				
				patient.patientId=rs.getLong("patientId");
				patient.firstName=rs.getString("firstName");
				patient.lastName=rs.getString("lastName");
				patient.email=rs.getString("email");
				patient.password=rs.getString("password");
				patient.bloodGroup=rs.getString("bloodGroup");
				patient.bmi=rs.getString("bmi");
				
				
				return patient;
		 }
		}catch(Exception e){
			e.printStackTrace();
		}  
		return null;  
	}
	
	public static boolean isEmailAvilable(String email) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			PreparedStatement ps = con.prepareStatement("select * from patient where email='"+email+"'");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	public static Patient validateCredentials(String email, String password) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
			PreparedStatement ps = con.prepareStatement("select * from patient where email=? and password=?");
			ps.setString(1,email );
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient p=new Patient();
				
				p.patientId=rs.getLong("patientId");
				p.firstName=rs.getString("firstName");
				p.lastName=rs.getString("lastName");
				p.email=rs.getString("email");
				p.password=rs.getString("password");
				p.bloodGroup=rs.getString("bloodGroup");
				p.bmi=rs.getString("bmi");
				
				return p;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	public static List<Patient> findAllPatients() {
		List<Patient> patients=new ArrayList<Patient>();
		try{  
			
			Connection con=JdbcConnection.getJDBC_connection();  
				PreparedStatement ps=con.prepareStatement( "select * from patient");
				ResultSet r=ps.executeQuery();
				while(r.next()){
					Patient p=new Patient();
					p.patientId=r.getLong("patientId");
					p.firstName=r.getString("firstName");
					p.lastName=r.getString("lastName");
					p.email=r.getString("email");
					p.password=r.getString("password");
					p.bloodGroup=r.getString("bloodGroup");
					p.bmi=r.getString("bmi");
					
					patients.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return patients;
	}

	public static Patient findById(long patientId) {
		try{  
			
			Connection con=JdbcConnection.getJDBC_connection();  
				PreparedStatement ps=con.prepareStatement( "select * from patient where patientId="+patientId+";");
				ResultSet r=ps.executeQuery();
				while(r.next()){
					Patient p=new Patient();
					p.patientId=r.getLong("patientId");
					p.firstName=r.getString("firstName");
					p.lastName=r.getString("lastName");
					p.email=r.getString("email");
					p.password=r.getString("password");
					p.bloodGroup=r.getString("bloodGroup");
					p.bmi=r.getString("bmi");
					
					return p;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	

	public static void delete(String userId) throws SQLException {
		
			   String q="delete from patient where patientid='"+userId+"';";
			   System.out.println("Query:"+q);
			   Connection connection=JdbcConnection.getJDBC_connection();
			   Statement statement = connection.createStatement();
			    statement.execute(q);
			    	
	}

	public static void updatePatient(long patient, String psw) throws SQLException {

		//update omss.patient p set password='vamsi' where patientid=20;
		String q="update patient p set password='"+psw+"' where patientid='"+patient+"';";
		   System.out.println("Query:"+q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);
	}
	
	public static void main(String[] args) {
		Patient p=new Patient();
		p.bloodGroup="o+";
		p.bmi="23";
		p.email="surya@gmal.com";
		p.firstName="sury";
		p.lastName="a";
		p.password="abc";
		p.gender="male";
		Patient p2=createPatient(p);
		System.out.println(p2.getPatientId());
	}
}
