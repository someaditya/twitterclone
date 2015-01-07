<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*,java.util.*,java.util.Date,java.io.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 final String DB_URL = "jdbc:mysql://localhost/twitterproject";


 final String USER = "root";
 final String PASS = "root";
 
 Connection conn = null;
 Statement stmt = null;
 
String fname = null;
String lname =  null;
String city = null;
     Class.forName("com.mysql.jdbc.Driver");
     Scanner s = new Scanner(System.in);

     conn = DriverManager.getConnection (DB_URL, USER, PASS);
     stmt = conn.createStatement();
     

         String userid = (String)session.getAttribute("userid");
         
         System.out.println(userid);
         
         ResultSet rs;
         rs = stmt.executeQuery("select * from person where user_id='" + userid + "'");
         if (rs.next()) {
         
           fname = rs.getString("fname");
         lname = rs.getString("lname");
         city = rs.getString("city");
         }
      	%>
      	<%=fname %>
      	<%=lname %><br>
      	<%=city %><br><br>
<table class="tweetlist"><tr>
<td><a href="getprofiledetails" >Tweets <%=session.getAttribute("tweet_count").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="getprofiledetails" >Following <%=session.getAttribute("following").toString()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="getprofiledetails" >Followers <%=session.getAttribute("followers").toString()%></a></td>
</tr>
</table>
</body>
</html>