<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*,java.sql.*,java.util.*,java.util.Date,java.io.*"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
 <%@ include file="top.jsp" %>
 Hello <%=session.getAttribute("userid").toString()%> <br>
 <div align="center" id="searchresults" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:px; z-index:2">
<s:iterator  value="list" var="i">  
<fieldset>  
<tr><td><font class="ws200">UserName : </font><font class="ws201" ><b><s:property value="userid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
</td> <td> <font class="ws200">Name : </font><font class="ws201"><b><s:property value="fname"/><s:property value="lname"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font></td></tr> 
<font class="ws200"> City : </font><font class="ws201"><b><s:property value="city"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></font> 
<font class="ws200">EmailId : </font><font class="ws201"><b><s:property value="email"/></b></font><br/> 
</br> 
<tr><td><a href="" >Tweets <%=session.getAttribute("tweet_count1").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="following" >Following <%=session.getAttribute("following1").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="followers" >Followers <%=session.getAttribute("followers1").toString()%></a></td>
</tr>
</fieldset>  
</s:iterator>
<%
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
final String DB_URL = "jdbc:mysql://localhost/twitterproject";


final String USER = "root";
final String PASS = "root";

Connection conn = null;
Statement stmt = null;

String userid = null;
String pwd =null;
String user =null;
    
    Class.forName("com.mysql.jdbc.Driver");
    Scanner s = new Scanner(System.in);

    conn = DriverManager.getConnection (DB_URL, USER, PASS);
    stmt = conn.createStatement();
     String user_id=session.getAttribute("userid").toString();
     String profileid=session.getAttribute("profile").toString();
        ResultSet rs;
        rs = stmt.executeQuery("select * from following where user_id='" +user_id+ "' and following_id='" +profileid+ "'");
        if (rs.next()) {
 
   %>
   <form action="follow" method="post">
<input type="submit" class="mybutton2" value="UnFollow"/>
</form>
<%
        }
        else {
%>

  <form action="follow" method="post">
<input type="submit" class="mybutton" value="Follow"/>
</form>
<%
}%>
<s:action name="GetTweets2" executeResult="true" />
</div>
<%@ include file="bottom.jsp" %>