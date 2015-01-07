package com.twitter.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import com.twitter.DAO.LoginDAO;
import com.twitter.DAO.ProfileDetailsDAO;

public class GetProfileDetails extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	HttpSession s;
	LoginDAO logindao=new LoginDAO();
	String userid = (String) s.getAttribute("userid");
	String password = (String) s.getAttribute("password");
	
	public String execute() throws SQLException{
	    if(logindao.validate(userid, password)){
		
		ProfileDetailsDAO profiledetails = new ProfileDetailsDAO();
		if(profiledetails.getdetails(userid,password))
		{	
		return "success";
		}
	    
		else
		{
		
		return "error";
		}
	
	}
	    else
		{
		
		return "error";
		}
	}
}

