package com.twitter.details;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;
public class ProfileDetailsBean extends ActionSupport{
private static final long serialVersionUID = 1L;
private String userid;
private String password;
public String fullname;
public String email;
public Timestamp time;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
public void setTime(java.sql.Timestamp timestamp) {
	// TODO Auto-generated method stub
	
}

}