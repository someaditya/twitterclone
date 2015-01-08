package com.twitter.actions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.DAO.*;
import com.twitter.actions.*;
public class DeleteProfile extends ActionSupport implements SessionAware{
private static final long serialVersionUID = 1L;
private String CurrentPassword;
public String getCurrentPassword() {
	return CurrentPassword;
}
public void setCurrentPassword(String currentPassword) {
	CurrentPassword = currentPassword;
}

public String getRePassword() {
	return rePassword;
}
public void setRePassword(String rePassword) {
	this.rePassword = rePassword;
}

private String rePassword;
public Map session;


public void setSession(Map session) 
{ 
	this.session = session;
}
public String execute() throws SQLException{
	 HttpSession session=ServletActionContext.getRequest().getSession(false);
		String userid= (String)session.getAttribute("userid");
	
		
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=con.prepareStatement("select count(*) from person where user_id =? and password=?");
		stmt.setString(1,userid);
		stmt.setString(2,CurrentPassword);
		ResultSet rs=stmt.executeQuery();
		int i=0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		/*Checks Current password*/
		if(i==0){
			System.out.println("Entered password is nt correct");
			return "error";
			}
		else 
			{
			if(rePassword.equals(CurrentPassword)){
			    
				Connection con3=ConnectionProvider.getConnection();
				PreparedStatement stmt3=con3.prepareStatement("delete from tweet where user_id = '"+userid+"';");
				int l = stmt3.executeUpdate();
				System.out.println("Tweets Deleted");
				Connection con2=ConnectionProvider.getConnection();
				PreparedStatement stmt2=con2.prepareStatement("delete from following where user_id = '"+userid+"' OR following_id = '"+userid+"'");
				int k = stmt2.executeUpdate();
				System.out.println("Following Deleted");
				Connection con1=ConnectionProvider.getConnection();
				PreparedStatement stmt1=con1.prepareStatement("delete from person where user_id = '"+userid+"';");
				int j = stmt1.executeUpdate();
				System.out.println("Person Deleted");
				System.out.println("Profile Deleted");
				return "success";	
			}
			else{
			System.out.println("Both are entered passwords are not equal");
		
			System.out.println(rePassword);
				return "error";
			}		
	}
}
}
