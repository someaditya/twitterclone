<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<LINK rel=StyleSheet HREF="main.css" TYPE="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Twitter </title>
</head>

<h1 align="center">Twitter </h1>
Welcome <%=session.getAttribute("userid").toString()%>
<div align="right">
<a href=home.jsp>Home</a>
<a href="<%= request.getContextPath() %>/profile.action">Profile</a>
<a href="<%= request.getContextPath() %>/logout.action">Logout</a>
</div><br>
<center>
<s:form action="TweetAction">
<div align="center">
<s:textarea name="tweet_update" cols="90" rows="5" value="What's on your mind ?" /><br></div>
<div align="right"><s:submit value="Update"></s:submit></div>
</s:form>
</center>
</body>
</html>