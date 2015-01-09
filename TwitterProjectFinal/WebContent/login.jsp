<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>


</head>
 <LINK rel=StyleSheet HREF="main.css" TYPE="text/css">

<h1 align="center">Welcome to Twitter</h1>
<h2 align="center">Login Page</h2>

<div align="center">
<s:form action="login">
<s:textfield name="userid" label="UserId" />
<s:password name="password" label="Password" />
<s:submit value="Submit"></s:submit>
</s:form>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<label class="label3"><a href="index.jsp">New User?Register Here</a></label>
</div>
</body>
</html>