package com.twitter.details;

import java.sql.Timestamp;

public class SearchListBean {
	
	public String searchstring;
	public String userid;
	public Timestamp created;

	public String getSearchstring() {
		return searchstring;
	}

	public void setSearchstring(String searchstring) {
		this.searchstring = searchstring;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Cloneable getCreated() {
		return created;
	}

	public void setCreated(Timestamp timestamp) {
		this.created = timestamp;
	}

}
