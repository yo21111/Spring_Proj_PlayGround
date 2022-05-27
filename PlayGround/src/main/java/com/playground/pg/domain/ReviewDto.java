package com.playground.pg.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReviewDto {
	
	private int no;
	private String title;
	private String content;
	private String id;
	private int exNo;
	private int viewCnt;
	private int score;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;
	

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getExNo() {
		return exNo;
	}
	public void setExNo(int exNo) {
		this.exNo = exNo;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	
}
