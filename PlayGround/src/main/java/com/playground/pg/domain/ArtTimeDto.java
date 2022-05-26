package com.playground.pg.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ArtTimeDto {
	private int exNo_FK;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date exDate1;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date exDate2;
	private String exTime1_1;
	private String exTime1_2;
	private String exTime1_3;
	private String exTime2_1;
	private String exTime2_2;
	private String exTime3_1;
	private String exTime3_2;
	public int getExNo_FK() {
		return exNo_FK;
	}
	public void setExNo_FK(int exNo_FK) {
		this.exNo_FK = exNo_FK;
	}
	public Date getExDate1() {
		return exDate1;
	}
	public void setExDate1(Date exDate1) {
		this.exDate1 = exDate1;
	}
	public Date getExDate2() {
		return exDate2;
	}
	public void setExDate2(Date exDate2) {
		this.exDate2 = exDate2;
	}
	public String getExTime1_1() {
		return exTime1_1;
	}
	public void setExTime1_1(String exTime1_1) {
		this.exTime1_1 = exTime1_1;
	}
	public String getExTime1_2() {
		return exTime1_2;
	}
	public void setExTime1_2(String exTime1_2) {
		this.exTime1_2 = exTime1_2;
	}
	public String getExTime1_3() {
		return exTime1_3;
	}
	public void setExTime1_3(String exTime1_3) {
		this.exTime1_3 = exTime1_3;
	}
	public String getExTime2_1() {
		return exTime2_1;
	}
	public void setExTime2_1(String exTime2_1) {
		this.exTime2_1 = exTime2_1;
	}
	public String getExTime2_2() {
		return exTime2_2;
	}
	public void setExTime2_2(String exTime2_2) {
		this.exTime2_2 = exTime2_2;
	}
	public String getExTime3_1() {
		return exTime3_1;
	}
	public void setExTime3_1(String exTime3_1) {
		this.exTime3_1 = exTime3_1;
	}
	public String getExTime3_2() {
		return exTime3_2;
	}
	public void setExTime3_2(String exTime3_2) {
		this.exTime3_2 = exTime3_2;
	}
	
	
}
