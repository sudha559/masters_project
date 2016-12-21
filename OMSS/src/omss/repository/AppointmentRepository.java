package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omss.domain.Appointment;

public class AppointmentRepository {

	public static List<Appointment> findByOnlineAppointment() {
		List<Appointment> appointments=new ArrayList<>();

		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where appointmentType='Online';");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setPatientName(rs.getString("patientName"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
	
		
		return appointments;
	}

	public static List<Appointment> findByWalkInAppointment() {
		List<Appointment> appointments=new ArrayList<>();

		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where appointmentType='Walkin';");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setPatientName(rs.getString("patientName"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
	
		
		return appointments;
	}

	public  static boolean save(Appointment appointment) {
		
		try{  
		  
		Connection con=JdbcConnection.getJDBC_connection();  
		      
		PreparedStatement ps=con.prepareStatement( "INSERT INTO appointment (doctorName,doctorId,patientName,patientId,appointmentType,appointmentDate,medicalReports,description) "
                + "VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, appointment.getDoctorName());
			ps.setLong(2, appointment.getDoctorId());
			ps.setString(3, appointment.getPatientName());
			ps.setLong(4, appointment.getPatientId());
			ps.setString(5, appointment.getAppointmentType());
			ps.setString(6, appointment.getAppointmentDate() !=null? appointment.getAppointmentDate() :"");
			ps.setString(7,appointment.getMedicalReports());
			ps.setString(8,appointment.getDescription());
		
			return ps.execute();
		
		}catch(Exception e){
			e.printStackTrace();
		}  
		return false; 
		
	}

	public static List<Appointment> findByOnlineAppointmentByDoctor(long doctorid) {

		List<Appointment> appointments=new ArrayList<>();

		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where appointmentType='Online' and doctorid="+doctorid+";");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setPatientName(rs.getString("patientName"));
				appointment.setDescription(rs.getString("description"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		return appointments;
	}

	public static List<Appointment> findByWalkInAppointmentByDoctor(long doctorid) {

		List<Appointment> appointments=new ArrayList<>();

		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where appointmentType='Walkin' and doctorid="+doctorid+";");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setPatientName(rs.getString("patientName"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setDescription(rs.getString("description"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		return appointments;
	}

	public static List<Appointment> findAppointmentsByPatient(long userid) {


		List<Appointment> appointments=new ArrayList<>();

		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where patientId="+userid+";");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setPatientName(rs.getString("patientName"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setDescription(rs.getString("description"));
				appointment.setAppointmentDate(rs.getString("appointmentDate"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		return appointments;
	
	}

	public static void deleteByDoctorid(String userId) throws SQLException {
		   String q="delete from appointment  where doctorId="+userId+"";
		   System.out.println(q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);
		
	}

	public static void deleteByPatientid(String userId) throws SQLException {
		 String q="delete from appointment  where patientId="+userId+"";
		 System.out.println(q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);		
	}

	public static List<Appointment> findAppointmentByDoctor(long userid, String type) {
		List<Appointment> appointments=new ArrayList<>();
		//select * from appointment t where appointmentType='Walkin' and doctorid=
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from appointment t where doctorId="+userid+" and appointmentType='"+type+"';");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Appointment appointment=new Appointment();
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setDoctorId(rs.getLong("doctorId"));
				appointment.setPatientName(rs.getString("patientName"));
				appointment.setDoctorName(rs.getString("doctorName"));
				appointment.setAppointmentId(rs.getLong("appointmentId"));
				appointment.setAppointmentType(rs.getString("appointmentType"));
				appointment.setMedicalReports(rs.getString("medicalReports"));
				appointment.setDescription(rs.getString("description"));
				appointment.setAppointmentDate(rs.getString("appointmentDate"));
				
				appointments.add(appointment);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		return appointments;
	
	
	}

	public static void update(long id, String date) throws SQLException {
		String q="update appointment d set appointmentDate='"+date+"' where appointmentId='"+id+"';";
		   System.out.println("Query:"+q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);
	}
 

}
