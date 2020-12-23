package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.entity.UserDetails;

public class UserService {

	
	public List<UserDetails> getAllUsers(){
		Connection con = DbConnection.getConnection();
		Statement st;
		List<UserDetails> users= new ArrayList<UserDetails>();
		
		try {
			st = con.createStatement();
			ResultSet rs= st.executeQuery("select *from user_login");
			while (rs.next()) {
				UserDetails user= new UserDetails();
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("full_name"));
				user.setPhone(rs.getString("phone"));
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("user_pass"));
				user.setUsername(rs.getString("user_name"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return users;
	}
	
	
	 
}
