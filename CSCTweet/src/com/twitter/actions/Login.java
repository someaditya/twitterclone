package com.twitter.actions;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twitter.DAO.LoginDAO;
import com.twitter.DAO.ProfileDetailsDAO;
import com.twitter.DAO.RegisterDAO;
import com.twitter.actions.*;
public class Login extends ActionSupport implements SessionAware{
private static final long serialVersionUID = 1L;
private String userid;
private String password;
public Map session;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
LoginDAO logindao=new LoginDAO();
ProfileDetailsDAO profiledao = new ProfileDetailsDAO();
public void setSession(Map session) 
{ 
	this.session = session;
}
public String execute() throws SQLException{
	session.put("userid", getUserid());
	session.put("password", getPassword());
	
if(logindao.validate(userid, password)){
	//GetTweets gt = new GetTweets();
	
	
	
/*	if(profiledao.getdetails(userid, password)){
		System.out.println("get details working");
	}
	else
	{
		System.out.println("get details not working");
	}*/
this.addActionError("You have successfully inserted data.");
return "success";}
else
this.addActionError("Data is not successfully inserted");
return "error";
}
public String logout(){
	if(session!=null){
		session.remove("userid");
		session.remove("password");
		}
	return "success";
}
}
