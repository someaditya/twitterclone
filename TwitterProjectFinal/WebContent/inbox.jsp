<%@ page import="java.sql.*,java.util.*,java.util.Date,java.io.*" %>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>

<div align="center" id="mytweetsform" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">
<% String username = (String)session.getAttribute( "userid" );

String profile = (String)session.getAttribute( "profile" ); %>


<center>


 <form action="sendmessage.jsp" method="post" name="message" onsubmit="return validatemessage()">
<table>
<tr>
  <th> Write the username of the Reciever </th>
   <th> Write the Message </th>
 </tr>
 <tr>
   
 <td><input type="text" name ="reciever" value="<%=profile %>"class="input" /> </td>
 <td><textarea name="message" cols="100" rows="4" placeholder="Write Your Message !!!!"></textarea> </td>			     
<td> <input type="submit" value="Send" class="input"/></td>
   
 </tr>                      
</table>

     </form> 
 </center>

<h4>Threads</h4>

<%

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
<label class ="label7"><%= uname1%> </label> to
<label class ="label6"><%= uname2 %></label>          "
<label class ="label5"><%= message %> </label>"
</center>
<% } %>
<br>

   
 
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
   </div>
<%@ include file="bottom.jsp" %>
