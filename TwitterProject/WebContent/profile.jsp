<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <LINK rel=StyleSheet HREF="main.css" TYPE="text/css">
</head>

<div align="right"><a href=home.jsp>Home</a>
<a href="profile.jsp">Profile</a>
<a href="<%= request.getContextPath() %>/logout.action">Logout</a></div>
Hello <%=session.getAttribute("userid").toString()%>,  Welcome to Your Profile <br>
<jsp:useBean id="u" class="com.twitter.details.ProfileDetailsBean"></jsp:useBean> 
Record:<br>  
<jsp:getProperty property="userid" name="u"/><br>  
<jsp:getProperty property="fullname" name="u"/><br>  
<jsp:getProperty property="email" name="u" /><br>
<jsp:getProperty property="time" name="u" /><br>

</body>
</html>