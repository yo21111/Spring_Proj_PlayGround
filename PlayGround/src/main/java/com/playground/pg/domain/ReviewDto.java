package com.playground.pg.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReviewDto {
	
	private int no;
	private String title;
	private String content;
	private String id_FK;
	private int exNo_FK;
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
	public String getId_FK() {
		return id_FK;
	}
	public void setId_FK(String id_FK) {
		this.id_FK = id_FK;
	}
	public int getExNo_FK() {
		return exNo_FK;
	}
	public void setExNo_FK(int exNo_FK) {
		this.exNo_FK = exNo_FK;
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
	
	@Override
	public String toString() {
		return "ReviewDto [no=" + no + ", title=" + title + ", content=" + content + ", id_FK=" + id_FK + ", exNo_FK="
				+ exNo_FK + ", viewCnt=" + viewCnt + ", score=" + score + ", writeDate=" + writeDate + "]";
	}
	
}
