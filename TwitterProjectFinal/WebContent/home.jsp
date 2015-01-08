<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>

<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">


<form action="TweetAction1" method="post" name="tweet" onsubmit="return validatetweet()">
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