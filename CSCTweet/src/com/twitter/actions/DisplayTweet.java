package com.twitter.actions;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.twitter.details.TweetBean;

public class DisplayTweet {
	ArrayList<TweetBean> list=new ArrayList<TweetBean>();

	public ArrayList<TweetBean> getList() {
		return list;
	}
	public void setList(ArrayList<TweetBean> list) {
		this.list = list;
	}

	public String displaytweet1(){
		 HttpSession session=ServletActionContext.getRequest().getSession(false);
		String userid= (String)session.getAttribute("userid");
		System.out.println(userid);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/twitterproject","root","root");
			PreparedStatement ps=con.prepareStatement("select user_id,message,created,tweet_id from tweet where user_id='"+userid+"' order by created desc;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TweetBean twt=new TweetBean();
		
				twt.setTweet_update(rs.getString(2));
				twt.setUser_id(rs.getString(1));
				twt.setTweet_id(rs.getInt(4));
				
				twt.setCreated(rs.getTimestamp(3));
				
				list.add(twt);
				
			}
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return "success";
   }
	
	public String displaytweet2(){
		 HttpSession session=ServletActionContext.getRequest().getSession(false);
		String userid= (String)session.getAttribute("profile");
		System.out.println(userid);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/twitterproject","root","root");
			PreparedStatement ps=con.prepareStatement("select user_id,message,created from tweet where user_id='"+userid+"' order by created desc ;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TweetBean twt=new TweetBean();
		
				twt.setTweet_update(rs.getString(2));
				twt.setUser_id(rs.getString(1));
				twt.setCreated(rs.getTimestamp(3));
				list.add(twt);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return "success";
  }
	public String displaytweet3(){
		 HttpSession session=ServletActionContext.getRequest().getSession(false);
		String userid= (String)session.getAttribute("userid");
		System.out.println(userid);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/twitterproject","root","root");
			PreparedStatement ps=con.prepareStatement("select a.message,b.following_id,a.created from tweet a INNER JOIN following b on b.user_id='"+userid+"' and b.following_id=a.user_id order by created desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TweetBean twt=new TweetBean();
		
				twt.setTweet_update(rs.getString(1));
				twt.setUser_id(rs.getString(2));
				twt.setCreated(rs.getTimestamp(3));
				list.add(twt);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return "success";
  }
}
