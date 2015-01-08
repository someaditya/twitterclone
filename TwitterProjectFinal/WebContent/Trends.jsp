<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*,java.util.Date,java.io.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trends</title>
</head>
<body>

What's Trending ? <br>
<br>
<% 
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 final String DB_URL = "jdbc:mysql://localhost/twitterproject";


 final String USER = "root";
 final String PASS = "root";
 
 Connection conn = null;
 Statement stmt = null;
 
 response.setIntHeader("Refresh", 5);

     
     Class.forName("com.mysql.jdbc.Driver");
     Scanner s = new Scanner(System.in);

     conn = DriverManager.getConnection(DB_URL, USER, PASS);
     stmt = conn.createStatement();
     ResultSet rs;
     rs = stmt.executeQuery("select distinct tweet from trends order by time desc limit 5" );
    
   while(rs.next()) {
     
      String trends = rs.getString(1);
      %>
      
      <label class ="label3"><%= trends%> </label><br>
      
      <%
   }
     
   %> 
</body>
</html>