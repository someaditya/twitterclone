package com.twitter.details;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

public class TweetBean {
public String tweet_update;
public String user_id;
public int tweet_id;

public Timestamp created;

public int getTweet_id() {
	return tweet_id;
}
public void setTweet_id(int tweet_id) {
	this.tweet_id = tweet_id;
}

public Cloneable getCreated() {
	return created;
}

public void setCreated(Timestamp timestamp) {
	this.created = timestamp;
}
public String getTweet_update() {
	return tweet_update;
}
public void setTweet_update(String tweet_update) {
	this.tweet_update = tweet_update;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}



}


