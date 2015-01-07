 <%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
 
 <div align="center" id="" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">
 

<form action="changepassword">
Current password :<input type=password name="CurrentPassword" label="Current Password" /></br>
New Password<input type=password name="NewPassword"" label="New Password" /></br>
Re-enter Password<input type=password name="rePassword" label="Re-enter Password" /></br>
<input type=submit value="Change Password"/>
</form>
</div>

<%@ include file="bottom.jsp" %>
