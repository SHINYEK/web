package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PostVO {
	private int id;
	private String title;
	private String body;
	private String writer;
	@JsonFormat(pattern="yyyy/MM/dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date date;
	private int viewcnt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	@Override
	public String toString() {
		return "PostVO [id=" + id + ", title=" + title + ", body=" + body + ", writer=" + writer + ", date=" + date
				+ ", viewcnt=" + viewcnt + "]";
	}
}
