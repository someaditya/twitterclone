package com.twitter.details;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;
public class ProfileDetailsBean extends ActionSupport{
private static final long serialVersionUID = 1L;
private String userid;
private String password;
public String fname;
public String lname;
public String email;
public String city;
public Timestamp time;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
	System.out.println("Bean Activated"+userid);
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
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