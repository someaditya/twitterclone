<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>Tweets :</h3> 
<s:iterator  value="alllist">
<tr><td><s:property value="tweet_update"/></td><td>Updated by <s:property value="user_id"/></td></tr></br>
</s:iterator>
