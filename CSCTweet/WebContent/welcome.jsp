<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>

<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:1000px; z-index:2">
<center>


<form action="TweetAction" method="post">
<table><tr><div align="center">
<td><textarea name="tweet_update" cols="90" rows="5" placeholder="What's on your mind ?"></textarea></td><br></div>
<td><input type=submit class=tweetbutton value="Tweet"></td></tr></table>
</form>
TweetCount == <%=session.getAttribute("tweet_count").toString()%>
</center>
<s:action name="AllTweets" executeResult="true" />
</div>
<%@ include file="bottom.jsp" %>