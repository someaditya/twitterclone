package com.twitter.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.twitter.DAO.RegisterDAO;
public class Register extends ActionSupport{
private static final long serialVersionUID = 1L;
private String userid;
private String password;
public String fname;
public String lname;
public String email;
public String city;


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
RegisterDAO registerdao=new RegisterDAO();
public String execute(){
if(registerdao.insert(userid, password, fname,lname,city, email)){
this.addActionError("You have successfully inserted data.");
	System.out.println("Inside Register.java Success");
return "success";}
else
this.addActionError("Data is not successfully inserted");
	System.out.println("Inside Register.java Error");
return "error";
}
}