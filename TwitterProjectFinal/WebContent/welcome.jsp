<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>

<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:1000px; z-index:2">
<center>


<form action="TweetAction" method="post"  name="tweet" onsubmit="return validatetweet()">
<table align="center">
<tr>
<td><iframe src="tweetcount.jsp" width=180px height=150px scrolling=no></iframe>&nbsp;&nbsp;&nbsp;</td> 
<td><textarea name="tweet_update" cols="70" rows="5" placeholder="What's on your mind ?"></textarea>&nbsp;&nbsp;&nbsp;</td>
<td><iframe src="Trends.jsp" width=180px height=150px scrolling=no></iframe></td>
</tr>
<tr>
<td></td>
<td align="center"><input type=submit class=tweetbutton value="Tweet"></td>
</tr>

</table>
</form>
<script>
function validatetweet()
{   var x = document.forms["tweet"]["tweet_update"].value;
     if (x == null || x == "") {
    alert("You cannot tweet blank space");
    return false;
}
	}
</script>
<s:action name="AllTweets" executeResult="true" />
</div>
<%@ include file="bottom.jsp" %>