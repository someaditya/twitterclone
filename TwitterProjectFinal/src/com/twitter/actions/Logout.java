package com.twitter.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
public class Logout extends ActionSupport {
public String execute() throws Exception {
Map session = ActionContext.getContext().getSession();
session.remove("userid");
session.remove("password");
session.remove("profile");

return "success";
}
} 