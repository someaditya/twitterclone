package com.twitter.DAO;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.User;
import org.apache.commons.beanutils.PropertyUtils;


import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.actions.GetProfileDetails;
import com.twitter.details.ProfileDetailsBean;

public class ProfileDetailsDAO {
	

	  
		public ArrayList<ProfileDetailsBean> list=new ArrayList<ProfileDetailsBean>();  
		  
		public ArrayList<ProfileDetailsBean> getList() {  
		    return list;  
		}  
		public void setList(ArrayList<ProfileDetailsBean> list) {  
		    this.list = list;  
		} 
		
	public boolean getdetails(String userid, String password)
	{
		
		Connection con=ConnectionProvider.getConnection();
		ProfileDetailsBean pro = new ProfileDetailsBean();
	
		
		
			
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from person where user_id =? and password=?");
			stmt.setString(1,userid);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				pro.setUserid(rs.getString(1));
				pro.setFname(rs.getString(3));
				pro.setLname(rs.getString(4));
				pro.setCity(rs.getString(5));
				pro.setEmail(rs.getString(6));
				
		        System.out.println(rs.getString(1));
		        list.add(pro); 
				
				
			}
			ListIterator<ProfileDetailsBean> itr=list.listIterator();
	        while(itr.hasNext())
	{
	            System.out.println(itr.next());
	        }
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
					}
		
		
		

		
	}
}
