package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO extends DAO {

	public UserDAO() {
		super();
	}
	
	public boolean checkLogin(User aUser) {
		boolean loginStatus = false;

		String sqlQuery = "SELECT name FROM tbl_user WHERE username = ? AND password = ?";		
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, aUser.getUsername());
			ps.setString(2, aUser.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aUser.setName(rs.getString("name"));
				loginStatus = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return loginStatus;
	}
}
