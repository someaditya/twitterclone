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
public class ChangePassword extends ActionSupport implements SessionAware{
private static final long serialVersionUID = 1L;
private String CurrentPassword;
public String getCurrentPassword() {
	return CurrentPassword;
}
public void setCurrentPassword(String currentPassword) {
	CurrentPassword = currentPassword;
}
public String getNewPassword() {
	return NewPassword;
}
public void setNewPassword(String newPassword) {
	NewPassword = newPassword;
}
public String getRePassword() {
	return rePassword;
}
public void setRePassword(String rePassword) {
	this.rePassword = rePassword;
}
private String NewPassword;
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
			if(NewPassword.equals(rePassword)){
			
				Connection con1=ConnectionProvider.getConnection();
				PreparedStatement stmt1=con.prepareStatement("update person set password = '"+NewPassword+"' where user_id='" + userid + "' and password='"+CurrentPassword+"';");
				int j = stmt1.executeUpdate();
				System.out.println("Password changed");
				return "success";	
			}
			else{
			System.out.println("Both are entered passwords are not equal");
			System.out.println(NewPassword);
			System.out.println(rePassword);
				return "error";
			}		
	}
}
}