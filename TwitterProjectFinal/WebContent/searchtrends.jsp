<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
<div align="center" id="searchresults" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:1000px; z-index:2">
<h2 align="center">Search Results</h2>
<s:iterator  value="list">
<fieldset> 
<s:property value="searchstring"/><br/>
<s:property value="created"/><br/>
<tr><s:url id="viewprofile" action="viewprofile">
<td><s:param name="userid" value="%{userid}"></s:param></td>
</s:url>
<td><s:a href="%{viewprofile}"><s:property value="userid"/></s:a></td>
</fieldset>
</s:iterator>
</div>
<%@ include file="bottom.jsp" %>