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
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;
import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.DAO.LoginDAO;
import com.twitter.DAO.ProfileDetailsDAO;
import com.twitter.details.ProfileDetailsBean;
import com.twitter.details.TweetBean;


public  class GetProfileDetails extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map session;	
	  
			public ArrayList<ProfileDetailsBean> profilelist=new ArrayList<ProfileDetailsBean>();  
			public ArrayList<TweetBean> mytweets=new ArrayList<TweetBean>();
			
			public ArrayList<ProfileDetailsBean> getPList() {  
			    return profilelist;  
			}  
			public void setPList(ArrayList<ProfileDetailsBean> profilelist) {  
			    this.profilelist = profilelist;  
			} 
			
	
			public ArrayList<TweetBean> getTweetList() {
				return mytweets;
			}
			public void setTweetList(ArrayList<TweetBean> mytweets) {
				this.mytweets = mytweets;
			}
		public String execute()
		{
			HttpSession session=ServletActionContext.getRequest().getSession(false); 
			Connection con=ConnectionProvider.getConnection();
			Connection con1=ConnectionProvider.getConnection();
			ProfileDetailsBean pro = new ProfileDetailsBean();
			
			 
			
			String userid = (String)session.getAttribute("userid");
			String password=(String)session.getAttribute("password");
			System.out.println("GetProfileDetailsWorking :: "+userid);
			
			PreparedStatement stmt1,stmt2;
			try {
				stmt1 = con.prepareStatement("select * from person where user_id =? and password=?");
				stmt1.setString(1,userid);
				stmt1.setString(2,password);
				ResultSet rs1=stmt1.executeQuery();
				while(rs1.next())
				{
					pro.setUserid(rs1.getString(1));
					pro.setFname(rs1.getString(3));
					pro.setLname(rs1.getString(4));
					pro.setCity(rs1.getString(5));
					pro.setEmail(rs1.getString(6));
				
			        System.out.println(rs1.getString(1));
			        profilelist.add(pro); 	
				}
				ListIterator<ProfileDetailsBean> itr=profilelist.listIterator();
		        while(itr.hasNext())
		        {
		            System.out.println("getprofiledetails"+itr.next());
		        }
		        
				stmt2=con1.prepareStatement("select user_id,message from tweet where user_id='"+userid+"' order by created desc;");
				
			
				ResultSet rs2=stmt2.executeQuery();
				while(rs2.next())
				{   TweetBean twt=new TweetBean();
                	twt.setTweet_update(rs2.getString(2));
					twt.setUser_id(rs2.getString(1));
					mytweets.add(twt);
					}
				return "success";
			
			} catch (SQLException e) {
				e.printStackTrace();

				return "error";
						}
			
			
			

			
		}
		@Override
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}



}

