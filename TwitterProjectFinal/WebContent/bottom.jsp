<script>
function validatesearch()
{   var x = document.forms["searchform"]["search"].value;
     if (x == null || x == "") {
    alert("You cannot search blank");
    return false;
}
	}
</script>

<div id="g_text1" style="position:absolute; overflow:hidden; left:300px; top:55px; width:400px; height:55px; z-index:5">
<form action="searchAction" method="post" name="searchform" onsubmit="return validatesearch()">
<tr><td><input type=text name="search" id="searchid"></td>
<td><input type=submit class="searchbutton" value="Search"></td></tr></form>
</div>

<div id="container">
<div id="g_image1" style="position:absolute; overflow:hidden; left:6px; top:21px; width:1130px; height:50px; z-index:1">
<img src="bar00.png" alt="" title="" border=0 width=1130 height=50>
</div>

<div id="image3" style="position:absolute; overflow:hidden; left:11px; top:84px; width:1118px; height:17px; z-index:2">
<img src="line5.gif" alt="" title="" border=0 width=1118 height=17>
</div>

<div id="g_text3" style="position:absolute; overflow:hidden; left:269px; top:803px; width:327px; height:38px; z-index:4">
<div class="wpmd">
<div>
<font class="ws8" color="#000000" face="Tahoma"></font></div>
</div>
</div>

<div id="g_text1" style="position:absolute; overflow:hidden; left:40px; top:12px; width:298px; height:50px; z-index:5">
<div class="wpmd">
<div><font color="#FFFFFF" face="Dancing Script" class="ws36"><B>t</B></font>
<font color="#FFFFFF" face="Dancing Script" class="ws20"><B>witter Clone</B></font>
</div>
</div>

</div>

<div id="text5" style="position:absolute; overflow:hidden; left:500px; top:30px; width:700px; height:150px; z-index:6">
<div class="wpmd">
<div>
	
<div class="menu-wrap">
    <nav class="menu">
        <ul class="clearfix">
<li><a href="<%= request.getContextPath()%>/GetTweets3.action" title="" class="style1">Home</a></li>
<li>
<a href="<%= request.getContextPath()%>/getprofiledetails.action" title="" class="style1">Profile</a></li>
<li>
<a  title="" class="style1"><span class="arrow">&#9660;</span>Settings</a>
<ul class="sub-menu">
                    <li><a href="changepassword.jsp">Change Password</a></li>
                    <li><a href="updateprofile.jsp">Update Profile</a></li>
                    <li><a href="DeleteProfile.jsp">Delete Profile</a></li>
                </ul></li>
                
   <li>             
<a href="<%= request.getContextPath()%>/logout.action" title="" class="style1">Logout</a></li>
 </ul>
    </nav>
</div>
</div>
</div>
</div>

</div>
</body>
</html>
