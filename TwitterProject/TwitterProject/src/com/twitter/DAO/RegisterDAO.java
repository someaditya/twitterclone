package com.twitter.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.twitter.ConnectionManager.ConnectionProvider;
public class RegisterDAO {	 	
public boolean insert(String userid,String password,String fullname,String email){
try{
Connection con=ConnectionProvider.getConnection();
PreparedStatement stmt=con.prepareStatement("insert into person values(?,?,?,?,CURRENT_TIMESTAMP,?)");

stmt.setString(1,userid);
stmt.setString(2,password);
stmt.setString(3,fullname);
stmt.setString(4,email);

stmt.setInt(5,1);
stmt.executeUpdate();
System.out.println("Inside RegisterDAO.java");
return true;
}catch(Exception e){
System.out.println(e);
}
return false;
}
}