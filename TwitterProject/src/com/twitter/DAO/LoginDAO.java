package com.twitter.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.twitter.ConnectionManager.ConnectionProvider;
public class LoginDAO {	 	
	public boolean validate(String userid,String password) throws SQLException{
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=con.prepareStatement("select count(*) from person where user_id =? and password=?");
		stmt.setString(1,userid);
		stmt.setString(2,password);
		ResultSet rs=stmt.executeQuery();
		int i=0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		if(i==0){
			return false;
		}
		else{
			return true;
		}
	}
}