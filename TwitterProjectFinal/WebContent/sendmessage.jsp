<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.*,java.util.Date,java.io.* ;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username = (String)session.getAttribute( "userid" );
String reciever1= request.getParameter("reciever");
String message= request.getParameter("message");

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
    rs = stmt.executeQuery("select user_id from following where user_id ='"+reciever1+"' and following_id='"+username+"';");
    
   
    if(rs.next()) {
    
    
    	
    		 int i = stmt.executeUpdate("insert into directmessage(user1,user2,message) values('"+username+"','"+reciever1+"','"+message+"') ");
    		  if(i!=0)
    	        {
    			  response.sendRedirect("inbox.jsp");
    	       } 
    	      
    	        else
    	        {
    	        response.sendRedirect("Chgpass.jsp");
    	        
    	        }
    	      }   
    else
    {
    	out.println("As "+reciever1+"  is not following you. Yo can't send a Direct Message !!");
    }
    		 
    	
    

%>
</body>
</html>