package com.example.domain;

import java.util.Date;

public class ReviewVO {
	private int id;
	private int code;
	private String body;
	private String writer;
	private Date date;
	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", code=" + code + ", body=" + body + ", writer=" + writer + ", date=" + date
				+ ", getId()=" + getId() + ", getCode()=" + getCode() + ", getBody()=" + getBody() + ", getWriter()="
				+ getWriter() + ", getDate()=" + getDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
}
