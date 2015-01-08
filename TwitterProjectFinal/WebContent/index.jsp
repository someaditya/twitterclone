<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
 <LINK rel=StyleSheet HREF="main.css" TYPE="text/css">



<h1 align="center">Welcome to Twitter</h1>
<h2 align="center">Registration Page</h2>
<div align="center">
<s:actionerror/>
<s:form action="register" >
<s:textfield name="userid" label="UserId"/>
<s:password name="password" label="Password"/>
<s:textfield name="fname" label="FullName"/>
<s:textfield name="lname" label="Last Name"/>
<s:textfield name="city" label="City"/>
<s:textfield name="email" label="Email"/>
<s:submit value="Submit"></s:submit>
</s:form>
</div>
</body>
</html>