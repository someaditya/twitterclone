 <%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
 
 <div align="center" id="" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">
 
<iframe src="changepassword.jsp"></iframe> 
</div>

<%@ include file="bottom.jsp" %>