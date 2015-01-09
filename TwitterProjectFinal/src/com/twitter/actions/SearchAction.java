package com.twitter.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twitter.ConnectionManager.ConnectionProvider;

import com.twitter.details.*;

public class SearchAction extends ActionSupport implements SessionAware {
public String search;

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}
ArrayList<SearchListBean> list=new ArrayList<SearchListBean>();

public ArrayList<SearchListBean> getList() {
	return list;
}
public void setList(ArrayList<SearchListBean> list) {
	this.list = list;
}

public String execute()
{
	String search = getSearch();
	
	 HttpSession session=ServletActionContext.getRequest().getSession(false);  
		String userid= (String)session.getAttribute("userid");
		System.out.println(userid);
		System.out.println("@  3   @ "+search);
		
		if(search.matches("#(.*)"))
			{
			try{
				
				Connection con=ConnectionProvider.getConnection();
				PreparedStatement stmt=con.prepareStatement("SELECT * from tweet where message like '%"+search+"%'order by created desc ;");

				
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(3));
		            SearchListBean twt=new SearchListBean();
					
					twt.setSearchstring(rs.getString(3));
					twt.setCreated(rs.getTimestamp(4));
					twt.setUserid(rs.getString(2));
				
					list.add(twt);
			
				}
				System.out.println("Inside search.java");
				return "success1";
				}catch(Exception e){
				System.out.println(e);
				}
				return "error";
				}

			
			
		else
		{
		if(search.trim().equals(""))
			{
				return "error";
			}
		else{
		try{
			
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT * from person where user_id<>'"+userid+"' and( fname like '%"+search+"%' OR lname like '%"+search+"%' OR user_id like '%"+search+"%');");

		
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(3));
            SearchListBean twt=new SearchListBean();
			
			twt.setSearchstring(rs.getString(3) + rs.getString(4));
			twt.setUserid(rs.getString(1));
			list.add(twt);
	
		}
		System.out.println("Inside search.java");
		return "success2";
		}catch(Exception e){
		System.out.println(e);
		}
		return "error";
		}
}

}
}




