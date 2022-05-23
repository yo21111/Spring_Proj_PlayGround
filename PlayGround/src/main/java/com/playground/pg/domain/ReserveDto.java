package com.playground.pg.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReserveDto {

	private int no;
	private int exNo;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date reDate;
	private String reTime1;
	private String reTime2;
	private int adCnt;
	private int chCnt;
	private int payment;
	private int point;
	private String uId;
	private int coupon;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getExNo() {
		return exNo;
	}
	public void setExNo(int exNo) {
		this.exNo = exNo;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public String getReTime1() {
		return reTime1;
	}
	public void setReTime1(String reTime1) {
		this.reTime1 = reTime1;
	}
	public String getReTime2() {
		return reTime2;
	}
	public void setReTime2(String reTime2) {
		this.reTime2 = reTime2;
	}
	public int getAdCnt() {
		return adCnt;
	}
	public void setAdCnt(int adCnt) {
		this.adCnt = adCnt;
	}
	public int getChCnt() {
		return chCnt;
	}
	public void setChCnt(int chCnt) {
		this.chCnt = chCnt;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	
}
