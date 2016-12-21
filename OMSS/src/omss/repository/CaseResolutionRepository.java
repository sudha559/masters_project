package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omss.domain.CaseResolution;

public class CaseResolutionRepository {


//"caseresolutionId","appointid","patientName","serialno","mediciname","courseDays","comments"         

	
public  static boolean save(CaseResolution caseResolution) {
		
		try{  
		  
		Connection con=JdbcConnection.getJDBC_connection();  
		      
		PreparedStatement ps=con.prepareStatement( "INSERT INTO caseresolution (appointid,patientName,serialno,mediciname,courseDays,comments,doctorName) "
                + "VALUES (?,?,?,?,?,?,?)");
		
			ps.setLong(1, caseResolution.getAppointid());
			ps.setString(2, caseResolution.getPatientName());
			ps.setString(3, caseResolution.getSerialno());
			ps.setString(4, caseResolution.getMediciname());
			ps.setString(5, caseResolution.getCourseDays());
			ps.setString(6,caseResolution.getComments());
			ps.setString(7,caseResolution.getDoctorName());
		
			return ps.execute();
		
		}catch(Exception e){
			e.printStackTrace();
		}  
		return false; 
		
	}

public static void main(String[] args) {
	CaseResolutionRepository c=new CaseResolutionRepository();
	CaseResolution caseResolution=new CaseResolution();
	caseResolution.setAppointid(5L);
	caseResolution.setPatientName("reddy");
	caseResolution.setComments("abc");
	caseResolution.setSerialno("1");
	caseResolution.setMediciname("abc");
	caseResolution.setCourseDays("10");
	c.save(caseResolution);
}

public static List<CaseResolution> findByAppointmentId(String appointmentId) {


	List<CaseResolution> caseResolutions=new ArrayList<>();

	
	try{ 
		Connection con=JdbcConnection.getJDBC_connection(); 
		PreparedStatement ps=con.prepareStatement("select * from caseresolution t where appointid="+appointmentId+";");  
				   
		ResultSet rs=ps.executeQuery();  
		while (rs.next()) {
			CaseResolution caseResolution=new CaseResolution();
			
			caseResolution.setCaseresolutionId(rs.getLong("caseresolutionId"));
			caseResolution.setAppointid(rs.getLong("appointid"));
			caseResolution.setPatientName(rs.getString("patientName"));
			caseResolution.setDoctorName(rs.getString("doctorName"));
			caseResolution.setSerialno(""+rs.getLong("serialno"));
			caseResolution.setCourseDays(rs.getString("courseDays"));
			caseResolution.setMediciname(rs.getString("mediciname"));
			caseResolution.setComments(rs.getString("comments"));
			
			caseResolutions.add(caseResolution);
		}
		rs.close();
		}catch(Exception e){
			e.printStackTrace();
		} 
	return caseResolutions;

}

public static void delete(String query) throws SQLException {
//SELECT * FROM caseresolution c where appointid in (SELECT appointmentid FROM appointment a where patientid=9);
	   String q="delete from caseresolution where appointid in (SELECT appointmentid FROM appointment a where "+query+")";
	   System.out.println(q);
	   Connection connection=JdbcConnection.getJDBC_connection();
	   Statement statement = connection.createStatement();
	    statement.execute(q);//executeQuery(q);
}

 
}
