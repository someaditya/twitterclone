<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>

<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">
<center>
<tr><td><a href="getprofiledetails" >Tweets <%=session.getAttribute("tweet_count").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="getprofiledetails" >Following <%=session.getAttribute("following").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="getprofiledetails" >Followers <%=session.getAttribute("followers").toString()%></a></td>
</tr>
<form action="TweetAction1" method="post">
<table><tr><div align="center">
<td><textarea name="tweet_update" cols="90" rows="5" placeholder="What's on your mind ?"></textarea></td><br></div>
<td><input type=submit class=tweetbutton value="Tweet"></td></tr></table>
</form>
</center>



<h3>Tweets </h3> 
<s:iterator  value="list" >
<fieldset> 
<tr><td><h3><font color="#e31212" face="Dancing Script" class="ws20"><s:property value="tweet_update"/></font></h3></td><td></td>Updated by&nbsp;<td>
<tr><s:url id="viewprofile" action="viewprofile">
<td><s:param name="userid" value="%{user_id}"></s:param></td>
</s:url>
<td><s:a href="%{viewprofile}"><s:property value="user_id"/></s:a></td>
&nbsp;</td><td><s:property value="created"/></td></tr></br>

</fieldset>
</s:iterator>
</div>
<%@ include file="bottom.jsp" %>