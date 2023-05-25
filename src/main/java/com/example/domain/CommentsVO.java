package com.example.domain;

import java.util.Date;

public class CommentsVO {
	private int id;
	private int postid;
	private String body;
	private String writer;
	private Date date;
	
	@Override
	public String toString() {
		return "CommentsVO [id=" + id + ", postid=" + postid + ", body=" + body + ", writer=" + writer + ", date="
				+ date + "]";
	}
	public int getId() {
		return id;		
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String wirter) {
		this.writer = wirter;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
