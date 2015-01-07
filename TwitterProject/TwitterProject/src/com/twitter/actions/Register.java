package com.twitter.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.twitter.DAO.RegisterDAO;
public class Register extends ActionSupport{
private static final long serialVersionUID = 1L;
private String userid;
private String password;
public String fullname;
public String email;
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
RegisterDAO registerdao=new RegisterDAO();
public String execute(){
if(registerdao.insert(userid, password, fullname, email)){
this.addActionError("You have successfully inserted data.");
	System.out.println("Inside Register.java Success");
return "success";}
else
this.addActionError("Data is not successfully inserted");
	System.out.println("Inside Register.java Error");
return "error";
}

}