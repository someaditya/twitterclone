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


public  class GetProfileDetails3 extends ActionSupport implements SessionAware , ApplicationAware {

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
		String userid;
		

		public void setServletRequest(HttpServletRequest request) {
	        this.request = request;
	    }

	    public HttpServletRequest getServletRequest() {
	        return request;
	    }


		public String execute()
		{
		  
			
			Connection con=ConnectionProvider.getConnection();
			ProfileDetailsBean pro = new ProfileDetailsBean();
		
			
			
			
			HttpSession session=ServletActionContext.getRequest().getSession(false);  
			String profileid= (String)session.getAttribute("profile");
			System.out.println("Visited Profile"+profileid);
			//String password=(String)session.getAttribute("password");
			System.out.println("GetProfileDetails3Working :: "+profileid);
			 
			//String userid="someaditya";
			//String password="java";
			
			
			//System.out.println("<-----");
			//String idUser = request.getParameter("userid");
		    //System.out.println("otehr menthod"+idUser);
			//System.out.println("----->");
		PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("select * from person where user_id =?");
				stmt.setString(1,profileid);
				//stmt.setString(2,password);
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
				HttpSession session1=ServletActionContext.getRequest().getSession(false); 
				PreparedStatement ps1=con.prepareStatement("select count(message) from tweet where user_id='"+profileid+"';");
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					
					int count = rs1.getInt(1);
					session1.setAttribute("tweet_count1", count);
					System.out.println("No ."+count);
				}
				PreparedStatement ps2=con.prepareStatement("select count(following_id) from following where user_id='"+profileid+"' AND following_id<>'"+profileid+"';");
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					
					int count = rs2.getInt(1);
					session1.setAttribute("following1", count);
					System.out.println("No . following"+count);
				}
				PreparedStatement ps3=con.prepareStatement("select count(user_id) from following where  following_id ='"+profileid+"' AND user_id<>'"+profileid+"' ;");
				ResultSet rs3=ps3.executeQuery();
				while(rs3.next()){
					
					int count = rs3.getInt(1);
					session1.setAttribute("followers1", count);
					System.out.println("No . followers"+count);
				}
				ListIterator<ProfileDetailsBean> itr=list.listIterator();
		        while(itr.hasNext())
		        {
		            System.out.println("getprofiledetails"+itr.next());
		        }
				return "success";
			
			} catch (SQLException e) {
				e.printStackTrace();

				return "error";
						}
			
			
			

			
		}
		public void setSession(Map session) 
		{ 
			this.session = session;
		}
		
		
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		@Override
		public void setApplication(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}



}

