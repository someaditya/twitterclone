package com.twitter.actions;
import com.twitter.details.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.twitter.ConnectionManager.ConnectionProvider;
import com.twitter.DAO.LoginDAO;


public class TweetAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
   /** 
	TweetBean tb = new TweetBean();
	
	public TweetBean getTb()
	{
		return tb;
	}
	
	public void setTb(TweetBean tb)
	{
		this.tb = tb;
	}
	
*/
	String tweet_update;

	public String getTweet_update() {
		return tweet_update;
	}

	public void setTweet_update(String tweet_update) {
		this.tweet_update = tweet_update;
	}
	
	public String execute() throws SQLException{
		
	//	String tweetupdate = tb.getTweet_update();
		
		String tweetupdate = getTweet_update();
		
		//TweetActionDAO tweetactiondao=new TweetActionDAO();
		
		System.out.println("@  1   @ "+tweetupdate);

		 HttpSession session=ServletActionContext.getRequest().getSession(false);  
		String userid= (String)session.getAttribute("userid");
		System.out.println(userid);
		System.out.println("@  3   @ "+tweetupdate);
		try{
			
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into tweet(user_id,message,created) values(?,?,CURRENT_TIMESTAMP)");

		stmt.setString(1,userid);
		stmt.setString(2,tweetupdate);
		stmt.executeUpdate();
		System.out.println("Inside TweetActionDAO.java");
		PreparedStatement ps1=con.prepareStatement("select count(message) from tweet where user_id='"+userid+"';");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next()){
			
			int count = rs1.getInt(1);
			session.setAttribute("tweet_count", count);
			System.out.println("No ."+count);
		}
		return "success";
		}catch(Exception e){
		System.out.println(e);
		}
		return "error";
	}

}
