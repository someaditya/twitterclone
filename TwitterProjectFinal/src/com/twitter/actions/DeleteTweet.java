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


public  class DeleteTweet extends ActionSupport implements SessionAware , ApplicationAware {

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
		int tweet_id;
		

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

		
			
			//HttpSession session=ServletActionContext.getRequest().getSession(false);  
			
			int tweet_id = getTweet_id();
			System.out.println("Delete tweet working"+tweet_id);
			//String password=(String)session.getAttribute("password");
			//System.out.println("GetProfileDetails2Working :: "+userid);
			 
	
		PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("delete from tweet where tweet_id =?");
				stmt.setInt(1,tweet_id);
				//stmt.setString(2,password);
				int rs=stmt.executeUpdate();
					if(rs!=0)
					{
								System.out.println("Delete tweet working !!! Yahoo !!!");
								
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
		public int getTweet_id() {
			return tweet_id;
		}
		public void setTweet_id(int tweet_id) {
			this.tweet_id = tweet_id;
		}



}


