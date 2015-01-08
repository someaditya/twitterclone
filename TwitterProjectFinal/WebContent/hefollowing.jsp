<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean,java.sql.*,java.util.*,java.util.Date,java.io.* "%>

    <%@ include file="top.jsp" %>
You are in <%=session.getAttribute("profile").toString()%>'s TimeLine <br>
<%    String userid = (String) session.getAttribute( "profile"); %>
<div align="center" id="searchresults" style="position:absolute; overflow:hidden; left:150px; top:150px; width:1000px; height:1000px; z-index:2">
<h2 align="center">Follower of <%=userid %></h2>


 <%       
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 final String DB_URL = "jdbc:mysql://localhost/twitterproject";


 final String USER = "root";
 final String PASS = "root";
 
 Connection conn = null;
 Statement stmt = null;
 
 

     
     Class.forName("com.mysql.jdbc.Driver");

     conn = DriverManager.getConnection(DB_URL, USER, PASS);
     stmt = conn.createStatement();
 
       
         ResultSet rs;
         rs = stmt.executeQuery("select fname ,lname ,user_id from person where user_id in (select following_id from following where user_id='"+userid+"' AND following_id<>'"+userid+"');");
      
         int i=0;
        
         while(rs.next()) {
 
                             i++;
      	
      	  String fname = rs.getString("fname");
          String lname = rs.getString("lname");
          String user_id = rs.getString("user_id");
      	%>
      	
<center>
  
  <fieldset>   	
 <h3> <%=fname %> <%=lname %> </h3>
<td><a href="viewprofile?userid=<%=user_id%>">View Profile</a></td>      </center>
  <%
         }
  %>      	
     
</div>
<%@ include file="bottom.jsp" %>