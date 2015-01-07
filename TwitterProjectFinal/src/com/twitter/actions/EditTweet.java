package com.twitter.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;
import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.DAO.LoginDAO;
import com.twitter.DAO.ProfileDetailsDAO;
import com.twitter.details.ProfileDetailsBean;
import com.twitter.details.TweetBean;


public  class EditTweet extends ActionSupport implements SessionAware , ApplicationAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map session;	
	public HttpServletRequest request;
	public Map m;
 
			public ArrayList<ProfileDetailsBean> list=new ArrayList<ProfileDetailsBean>();  
			  
			public ArrayList<ProfileDetailsBean> getList() {  
			    return list;  
			}  
			public void setList(ArrayList<ProfileDetailsBean> list) {  
			    this.list = list;  
			} 
		String tweet_message;
		

		public void setServletRequest(HttpServletRequest request) {
	        this.request = request;
	    }

	    public HttpServletRequest getServletRequest() {
	        return request;
	    }


		public String execute()
		{
		  
			
			Connection con=ConnectionProvider.getConnection();
			TweetBean twt=new TweetBean();

		
			
			HttpSession session=ServletActionContext.getRequest().getSession(false);  
			
			//int tweet_id = getTweet_id();
			//System.out.println("Edit tweet working"+tweet_id);
			String tid=(String)session.getAttribute("tid");
			java.sql.Timestamp time=(java.sql.Timestamp)session.getAttribute("time");
			System.out.println("Edit Tweet :: "+tid);
			System.out.println("EditTweet :: "+time);
	         String message = getTweet_message();
	         System.out.println(message);
		PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("Update tweet set message =? , created = ? where tweet_id =?");
				stmt.setString(1,message);
				stmt.setTimestamp(2,time);
				stmt.setString(3,tid);
				int rs=stmt.executeUpdate();
					if(rs!=0)
					{
								System.out.println("Edit tweet working !!! Yahoo !!!");
								
					}
				
					return "success";
					
			} catch (Exception e) {
				e.printStackTrace();

				return "error";
						}
			
			
			

			
		}
		public void setSession(Map session) 
		{ 
			this.session = session;
		}
		
		

	
		@Override
		public void setApplication(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}
		public String getTweet_message() {
			return tweet_message;
		}
		public void setTweet_message(String tweet_message) {
			this.tweet_message = tweet_message;
		}



}


