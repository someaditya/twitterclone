<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="deleteprofile" name="myForm" onsubmit="return validateForm()">
Current password :<input type=password name="CurrentPassword" label="Current Password" /></br>
Re-enter Password<input type=password name="RePassword" label="Re-enter Password" /></br>
<input type=submit value="Delete Profile"/>
</form>
</center>
<script>
function validateForm() {
    var x = document.forms["myForm"]["CurrentPassword"].value;
    var y = document.forms["myForm"]["RePassword"].value;
    if (x == null || x == "") {
        alert("Password must be filled out");
        return false;
    }
    else if (y == null || y == "") {
        alert("Confirm password must be filled out");
        return false;
    }
    else
    	{
    var r = confirm("Are You sure You want to delete your profile ?");
    if (r == true) {
        x = "You pressed OK!";
        return true;
    } else {
        x = "You pressed Cancel!";
        return false;
    } 
    	}
    
}

</script>
</body>
</html>