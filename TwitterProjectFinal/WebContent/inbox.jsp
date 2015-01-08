<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*,java.util.Date,java.io.* ;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<style type="text/css">
 input{
  width:220px;
  height:50px;
 
 
 }
</style>
<LINK rel=StyleSheet HREF="background.css" TYPE="text/css">
</head>
<body>
Threads
<%
String username = (String)session.getAttribute( "userid" );

String profile = (String)session.getAttribute( "profile" );
response.setIntHeader("Refresh", 20);
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
    rs = stmt.executeQuery("select * from directmessage where user1='" + username + "' || user2='" + username + "' order by time desc limit 20" );
   
  while(rs.next()) {
    
     String uname1 = rs.getString("user1");
     String uname2= rs.getString("user2");
     String  message= rs.getString("message");
   

%>

<center>
<label class ="label3"><%= uname1%> </label> to
<label class ="label3"><%= uname2 %></label>          "
<label class ="label3"><%= message %> </label>"
</center>
<% } %>
<br>
<center>


 <form action="sendmessage.jsp" method="post" name="message" onsubmit="return validatemessage()">
<table>
<tr>
  <th> Write the username of the Reciever </th>
   <th> Write the Message </th>
 </tr>
 <tr>
   <td>
 <td><input type="text" name ="reciever" value="<%=profile %>"class="input" /> </td>
 <td><textarea name="message" cols="100" rows="4" placeholder="Write Your Message !!!!"></textarea> </td>			     
<td> <input type="submit" value="Send" class="input"/></td>
   
 </tr>                      
</table>

     </form> 
 </center>
   
 
   <script>
   function validatemessage()
   {   var x = document.forms["message"]["message"].value;
       var y = document.forms["message"]["reciever"].value;

        if (x == null || x == "") {
       alert("You cannot send blank message");
       return false;
        }
       if (y == null || y == "") {
           alert("You cannot send your message to nobody");
           return false;
   
   	}
   }
   </script>
</body>
</html>