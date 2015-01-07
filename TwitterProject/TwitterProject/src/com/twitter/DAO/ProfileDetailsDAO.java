package com.twitter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.details.ProfileDetailsBean;

public class ProfileDetailsDAO {

	public boolean getdetails(String userid, String password)
	{
		
		Connection con=ConnectionProvider.getConnection();
		ProfileDetailsBean pro = new ProfileDetailsBean();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select count(*) from person where user_id =? and password=?");
			stmt.setString(1,userid);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				pro.setUserid(rs.getString(1));
				pro.setFullname(rs.getString(3));
				pro.setEmail(rs.getString(4));
				pro.setTime(rs.getTimestamp(5));
		
				
			}
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
					}
		
		
		

		
	}
}
