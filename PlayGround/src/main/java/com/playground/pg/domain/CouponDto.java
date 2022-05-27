package com.playground.pg.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CouponDto {
	private int no;
	private String id_FK;
	private String coupon;
	private int disRate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date couDate1;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date couDate2;
	private String couInfo;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId_FK() {
		return id_FK;
	}
	public void setId_FK(String id_FK) {
		this.id_FK = id_FK;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public int getDisRate() {
		return disRate;
	}
	public void setDisRate(int disRate) {
		this.disRate = disRate;
	}
	public Date getCouDate1() {
		return couDate1;
	}
	public void setCouDate1(Date couDate1) {
		this.couDate1 = couDate1;
	}
	public Date getCouDate2() {
		return couDate2;
	}
	public void setCouDate2(Date couDate2) {
		this.couDate2 = couDate2;
	}
	public String getCouInfo() {
		return couInfo;
	}
	public void setCouInfo(String couInfo) {
		this.couInfo = couInfo;
	}
	@Override
	public String toString() {
		return "CouponDto [no=" + no + ", id_FK=" + id_FK + ", coupon=" + coupon + ", disRate=" + disRate
				+ ", couDate1=" + couDate1 + ", couDate2=" + couDate2 + ", couInfo=" + couInfo + "]";
	}
}
