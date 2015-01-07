<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>
    <%@ include file="top.jsp" %>
Hello <%=session.getAttribute("userid").toString()%>,  Welcome to Your Profile <br>
<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:1000px; z-index:2">
<s:iterator  value="profilelist" var="i">  
<fieldset>  
<tr><td><font class="ws200">UserName : </font><font class="ws201" ><b><s:property value="userid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
</td> <td> <font class="ws200">Name : </font><font class="ws201"><b><s:property value="fname"/><s:property value="lname"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td></tr> 
<font class="ws200"> City : </font><font class="ws201"><b><s:property value="city"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font> 
<font class="ws200">EmailId : </font><font class="ws201"><b><s:property value="email"/></b></font><br/>  

<tr><td><a href="getprofiledetails" >Tweets <%=session.getAttribute("tweet_count").toString()%></a></td>
<td><a href="getprofiledetails" >Following <%=session.getAttribute("following").toString()%></a></td>
<td><a href="getprofiledetails" >Followers <%=session.getAttribute("followers").toString()%></a></td>
</tr>


</fieldset>   
</s:iterator>
<center>
<form action="TweetAction1" method="post">
<table><tr><div align="center">
<td><textarea name="tweet_update" cols="50" rows="5" placeholder="What's on your mind ?"></textarea></td><br></div>
<td><input type=submit class=tweetbutton value="Tweet"></td></tr></table>
</form>
</center>


<s:action name="GetTweets" executeResult="true" />

</div>
<%@ include file="bottom.jsp" %>