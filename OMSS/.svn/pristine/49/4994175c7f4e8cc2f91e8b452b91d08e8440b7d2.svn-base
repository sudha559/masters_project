package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import omss.domain.Specialization;

public class SpecializationRepository {

	public static List<Specialization> getAll() {

		List<Specialization> specializations=new ArrayList<>();
		
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from specialization");  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Specialization specialization=new Specialization();
				
				specialization.setSpecializationId(rs.getLong("specializationId"));
				specialization.setSpecializationName(rs.getString("specializationName"));
				specialization.setDescription(rs.getString("description"));
				
				specializations.add(specialization);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		
		 
		return specializations;
	
	}

	public static Specialization get(long specializationId) {
		try{ 
			Connection con=JdbcConnection.getJDBC_connection(); 
			PreparedStatement ps=con.prepareStatement("select * from specialization where specializationId="+specializationId);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Specialization specialization=new Specialization();
				
				specialization.setSpecializationId(rs.getLong("specializationId"));
				specialization.setSpecializationName(rs.getString("specializationName"));
				specialization.setDescription(rs.getString("description"));
				
				return specialization;
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			} 
		return null;
	}

}
