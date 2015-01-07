<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*,java.util.Date,java.io.*;" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String tweet_id = request.getParameter("tweet_id");
System.out.println("Edit_Tweet"+tweet_id);

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
        
        ResultSet rs;
        rs = stmt.executeQuery("select * from tweet where tweet_id="+tweet_id+"");
        while (rs.next()) {
        
        String tweet = rs.getString("message");
        Timestamp time = rs.getTimestamp("created");
       // String timex = time.toString();
        session.setAttribute("time", time);
        session.setAttribute("twee", tweet);
        System.out.println(time);
        System.out.println("Tweet to be edited --> "+tweet);
        }
     
        session.setAttribute("tid", tweet_id);
        

%>
<center>
<s:form action="tweetedit">
<div align="center">
<s:textarea name="tweet_message" cols="90" rows="5"  value="%{#session.twee}" /><br></div>
<div align="right"><s:submit value="Update Tweet"></s:submit></div>
</s:form>
</center>
</body>
</html>