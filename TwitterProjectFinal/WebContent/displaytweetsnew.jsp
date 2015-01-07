<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>Tweets :</h3> 
<s:iterator  value="list">
<fieldset>
<tr><td><h3><font color="#e31212" face="Dancing Script" class="ws20"><s:property value="tweet_update"/></font></h3></td><td></td>Updated by&nbsp;<td>
<tr><s:url id="viewprofile" action="viewprofile">
<td><s:param name="userid" value="%{user_id}"></s:param></td>
</s:url>
<td><s:a href="%{viewprofile}"><s:property value="user_id"/></s:a></td>
&nbsp;</td><td><s:property value="created"/></td></tr></br>


<s:url value="edittweet.jsp" var="url">
<s:param name="tweet_id" value="%{tweet_id}"></s:param>
</s:url>
<s:a href="%{url}">Edit</s:a>

<s:url id="tweetdelete" action="tweetdelete">
<s:param name="tweet_id" value="%{tweet_id}"></s:param>
</s:url>
<s:a href="%{tweetdelete}">Delete</s:a>


</fieldset>
</s:iterator>
