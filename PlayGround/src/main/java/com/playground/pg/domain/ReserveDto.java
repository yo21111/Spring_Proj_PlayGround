package com.playground.pg.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReserveDto {

	private int no;
	private int exNo_FK;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reDate;
	private String reTime1;
	private String reTime2;
	private int adCnt;
	private int chCnt;
	private int payment;
	private int point;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date payDate;
	private String id_FK;
	private Integer coupon_FK;

	// 관리자 메인페이지용 변수 : 해당 작품 입장 가능 인원
	private int allowNum;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getExNo_FK() {
		return exNo_FK;
	}

	public void setExNo_FK(int exNo_FK) {
		this.exNo_FK = exNo_FK;
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

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getId_FK() {
		return id_FK;
	}

	public void setId_FK(String id_FK) {
		this.id_FK = id_FK;
	}

	public Integer getCoupon_FK() {
		return coupon_FK;
	}

	public void setCoupon_FK(Integer coupon_FK) {
		this.coupon_FK = coupon_FK;
	}

	public int getAllowNum() {
		return allowNum;
	}

	public void setAllowNum(int allowNum) {
		this.allowNum = allowNum;
	}

	@Override
	public String toString() {
		return "ReserveDto [no=" + no + ", exNo_FK=" + exNo_FK + ", reDate=" + reDate + ", reTime1=" + reTime1
				+ ", reTime2=" + reTime2 + ", adCnt=" + adCnt + ", chCnt=" + chCnt + ", payment=" + payment + ", point="
				+ point + ", payDate=" + payDate + ", id_FK=" + id_FK + ", coupon_FK=" + coupon_FK + ", allowNum="
				+ allowNum + "]";
	}

}
