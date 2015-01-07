<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <%@ include file="top.jsp" %>
Welcome <%=session.getAttribute("userid").toString()%> <br>
 <%
 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 final String DB_URL = "jdbc:mysql://localhost/twitterproject";


 final String USER = "root";
 final String PASS = "root";

 Connection conn = null;
 Statement stmt = null;

String Fname = null;
     
     Class.forName("com.mysql.jdbc.Driver");
     Scanner s = new Scanner(System.in);

     conn = DriverManager.getConnection (DB_URL, USER, PASS);
     stmt = conn.createStatement();
     String userid = session.getAttribute("userid").toString();
     System.out.println("update"+userid);      
         ResultSet rs=null;
         rs = stmt.executeQuery("select * from person where user_id='"+userid+"'");
         while (rs.next()) {
         	
         		 Fname=rs.getString("fname");
         		String Lname=rs.getString("lname");
         		String City=rs.getString("city");
         		String Email=rs.getString("email");
         	    session.setAttribute("fname", Fname);
         	    session.setAttribute("lname", Lname);
         	    session.setAttribute("city", City);
         	    session.setAttribute("email", Email);
         	   System.out.println("Uopdater  ->"+Fname);
         	  
         	}
  rs.close();
%>
 <div align="center" id="" style="position:absolute; overflow:hidden; left:150px; top:150px; width:px; height:px; z-index:2">
 

<s:form action="UpdateDetails" method="post" >
<s:textfield name="fname" value="%{#session.fname}" label="First Name :" />
<s:textfield  name="lname"   value="%{#session.lname}" label="Last Name :"  />
<s:textfield  name="city"  value="%{#session.city}" label="City :" />
<s:textfield  name="email"  value="%{#session.email}" label="EmailID :"  />
<s:submit value="Update Profile"/>
</s:form>


</div>

<%@ include file="bottom.jsp" %>
