package com.twitter.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.twitter.DAO.RegisterDAO;
public class UpdateProfile extends ActionSupport{
private static final long serialVersionUID = 1L;

public String fname;
public String lname;
public String email;
public String city;

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
if(registerdao.update( fname,lname,city, email)){
this.addActionError("You have successfully inserted data.");
	System.out.println("Inside Register.java Success");
return "success";}
else
this.addActionError("Data is not successfully inserted");
	System.out.println("Inside Register.java Error");
return "error";
}
}