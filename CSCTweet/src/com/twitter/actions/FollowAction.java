package com.twitter.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.twitter.ConnectionManager.ConnectionProvider;

public class FollowAction {

	public String execute() throws SQLException{
		
	//	String tweetupdate = tb.getTweet_update();
		
		// tweetupdate = getTweet_update();
		
		//TweetActionDAO tweetactiondao=new TweetActionDAO();
		
	//	System.out.println("@  1   @ "+tweetupdate);
		String following=null;

		 HttpSession session=ServletActionContext.getRequest().getSession(false);  
		String userid= (String)session.getAttribute("userid");
		String followingid = (String)session.getAttribute("profile");
		System.out.println(userid);
		System.out.println(followingid);
		//System.out.println("@  3   @ "+tweetupdate);
		
		Connection con1=ConnectionProvider.getConnection();
		PreparedStatement stmt1;
			stmt1 = con1.prepareStatement("select following_id from following where user_id =? and following_id=?");
			stmt1.setString(1,userid);
			stmt1.setString(2,followingid);
			//stmt.setString(2,password);
			ResultSet rs=stmt1.executeQuery();
			System.out.println(rs.next());
			if(rs.last()==true)
			{
			
				Connection con2=ConnectionProvider.getConnection();
				PreparedStatement stmt2=con2.prepareStatement("delete from following where user_id= ? and following_id=?");
				stmt2.setString(1,userid);
				stmt2.setString(2,followingid);
				stmt2.executeUpdate();
				Connection con=ConnectionProvider.getConnection();
				PreparedStatement ps2=con.prepareStatement("select count(following_id) from following where user_id='"+userid+"' AND following_id<>'"+userid+"';");
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					
					int count = rs2.getInt(1);
					session.setAttribute("following", count);
					System.out.println("No . following"+count);
				}
				PreparedStatement ps3=con.prepareStatement("select count(user_id) from following where  following_id ='"+userid+"' AND user_id<>'"+userid+"' ;");
				ResultSet rs3=ps3.executeQuery();
				while(rs3.next()){
					
					int count = rs3.getInt(1);
					session.setAttribute("followers", count);
					System.out.println("No . followers"+count);
				}
			    return "success";
			
			}
			
			else{	
		Connection con3=ConnectionProvider.getConnection();
		PreparedStatement stmt3=con3.prepareStatement("insert into following(user_id,following_id) values(?,?)");
		stmt3.setString(1,userid);
		stmt3.setString(2,followingid);
		stmt3.executeUpdate();
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement ps2=con.prepareStatement("select count(following_id) from following where user_id='"+userid+"' AND following_id<>'"+userid+"';");
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next()){
			
			int count = rs2.getInt(1);
			session.setAttribute("following", count);
			System.out.println("No . following"+count);
		}
		PreparedStatement ps3=con.prepareStatement("select count(user_id) from following where  following_id ='"+userid+"' AND user_id<>'"+userid+"' ;");
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next()){
			
			int count = rs3.getInt(1);
			session.setAttribute("followers", count);
			System.out.println("No . followers"+count);
		}
		System.out.println(rs.last());
		System.out.println("Inside followAction.java");
		rs.close();
		return "success";
		}
			
	}
}