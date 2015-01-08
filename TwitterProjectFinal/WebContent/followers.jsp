<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean,java.sql.*,java.util.*,java.util.Date,java.io.* "%>

    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
<div align="center" id="searchresults" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:1000px; z-index:2">
<h2 align="center">Follower of You</h2>


 <%       
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 final String DB_URL = "jdbc:mysql://localhost/twitterproject";


 final String USER = "root";
 final String PASS = "root";
 
 Connection conn = null;
 Statement stmt = null;
 
 
 String user_id = null;
     
     Class.forName("com.mysql.jdbc.Driver");

     conn = DriverManager.getConnection(DB_URL, USER, PASS);
     stmt = conn.createStatement();
     String userid = (String) session.getAttribute( "userid");
       
         ResultSet rs;
         rs = stmt.executeQuery("select fname ,lname ,user_id from person where user_id in (select user_id from following where following_id='"+userid+"' AND user_id<>'"+userid+"');");
       
         while(rs.next()) {
 
      	  String fname = rs.getString("fname");
          String lname = rs.getString("lname");
          user_id = rs.getString("user_id");
          
          System.out.println(fname);
          System.out.println(lname);
          System.out.println(user_id);
 
      	%>
      	
<center>
  
  <fieldset>   	
 <h3> <%=fname %> <%=lname %> </h3>
>
<td><a href="viewprofile?userid=<%=user_id%>">View Profile</a></td>

      </center>
  <%
         }
  %>      	
     
</div>
<%@ include file="bottom.jsp" %>