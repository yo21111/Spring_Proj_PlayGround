package com.playground.pg.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FaqDto {
	private int no;
	private String category;
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	
	
	public int getNo() {
		return no;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "FaqDto [no=" + no + ", category=" + category + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", writeDate=" + writeDate + "]";
	}
	
}
