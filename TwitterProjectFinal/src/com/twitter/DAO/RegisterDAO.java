package com.twitter.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.twitter.actions.*;
import com.twitter.ConnectionManager.ConnectionProvider;
public class RegisterDAO {	 	
public boolean insert(String userid,String password,String fname,String lname,String city,String email){
try{
	 HttpSession session=ServletActionContext.getRequest().getSession(false);
Connection con=ConnectionProvider.getConnection();
Connection con3=ConnectionProvider.getConnection();


PreparedStatement stmt=con.prepareStatement("insert into person values(?,?,?,?,?,?)");

stmt.setString(1,userid);
stmt.setString(2,password);
stmt.setString(3,fname);
stmt.setString(4,lname);
stmt.setString(5,city);
stmt.setString(6,email);
stmt.executeUpdate();
System.out.println("Inside RegisterDAO.java");

PreparedStatement stmt3=con3.prepareStatement("insert into following(user_id,following_id) values(?,?)");
stmt3.setString(1,userid);
stmt3.setString(2,userid);
stmt3.executeUpdate();
System.out.println("Following own");

return true;
}catch(Exception e){
System.out.println(e);
}
return false;
}

public boolean update(String fname, String lname, String city, String email) {
	try{
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	String user_id = session.getAttribute("userid").toString();
	
	Connection con=ConnectionProvider.getConnection();
	PreparedStatement stmt=con.prepareStatement("update person set fname= ? , lname = ? , city = ? , email = ? where user_id ='"+user_id+"'");

	
	stmt.setString(1,fname);
	stmt.setString(2,lname);
	stmt.setString(3,city);
	stmt.setString(4,email);
	stmt.executeUpdate();
	System.out.println("Inside RegisterDAO.java  update function");
	// TODO Auto-generated method stub
	return true;
	}catch(Exception e){
	System.out.println(e);
	}
	return false;
}
}