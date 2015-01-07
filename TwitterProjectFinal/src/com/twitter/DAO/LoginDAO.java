package com.twitter.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
		 HttpSession session=ServletActionContext.getRequest().getSession(false);  
		PreparedStatement ps1=con.prepareStatement("select count(message) from tweet where user_id='"+userid+"';");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next()){
			
			int count = rs1.getInt(1);
			session.setAttribute("tweet_count", count);
			System.out.println("No ."+count);
		}
		PreparedStatement ps2=con.prepareStatement("select count(following_id) from following where user_id='"+userid+"' AND following_id<>'"+userid+"';");
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next()){
			
			int count = rs2.getInt(1);
			session.setAttribute("following", count);
			System.out.println("No . following"+count);
		}
		PreparedStatement ps3=con.prepareStatement("select count(user_id) from following where  following_id ='"+userid+"' AND user_id<>'"+userid+"' ;");
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next()){
			
			int count = rs3.getInt(1);
			session.setAttribute("followers", count);
			System.out.println("No . followers"+count);
		}
		if(i==0){
			return false;
		}
		else{
			return true;
		}
	}
}