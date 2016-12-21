package omss.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import omss.domain.Admin;

public class AdminRepository {

	public static Admin  validateCredentials(String email, String password) {
		try {
			Connection connection = JdbcConnection.getJDBC_connection();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where email=? and password=?");
			preparedStatement.setString(1,email );
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin=new Admin();
				
				admin.setAdminId(rs.getLong("adminId"));
				admin.setFirstName(rs.getString("firstName"));
				admin.setLastName(rs.getString("lastName"));
				admin.setSecurityquestion(rs.getString("securityquestion"));
				admin.setAnswer(rs.getString("answer"));
				return admin;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	public static Admin findById(long adminId) {
		try {
			Connection con = JdbcConnection.getJDBC_connection();

			PreparedStatement ps = con.prepareStatement("select * from admin where adminId="+adminId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin=new Admin();
				
				admin.setAdminId(rs.getLong("adminId"));
				admin.setFirstName(rs.getString("firstName"));
				admin.setLastName(rs.getString("lastName"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setGender(rs.getString("gender"));
				
				return admin;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	public static void updateUser(long adminid, String psw) throws SQLException {


		String q="update admin d set password='"+psw+"' where adminid='"+adminid+"';";
		   System.out.println("Query:"+q);
		   Connection connection=JdbcConnection.getJDBC_connection();
		   Statement statement = connection.createStatement();
		    statement.execute(q);
			
			
	}

}
