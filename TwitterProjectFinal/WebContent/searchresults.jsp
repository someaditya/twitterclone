<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
<div align="center" id="searchresults" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:1000px; z-index:2">
<h2 align="center">Search Results</h2>
<s:iterator  value="list" var="i">
<fieldset> 

<tr><td><font class="ws200">UserName : </font><font class="ws201" ><b><s:property value="userid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
</td> <td> <font class="ws200">Name : </font><font class="ws201"><b><s:property value="searchstring"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td></tr> 
 
<tr><s:url id="viewprofile" action="viewprofile">
<td><s:param name="userid" value="%{userid}"></s:param></td>
</s:url>
<td><s:a href="%{viewprofile}">View Profile</s:a></td>
</tr></fieldset>
</s:iterator>
</div>
<%@ include file="bottom.jsp" %>