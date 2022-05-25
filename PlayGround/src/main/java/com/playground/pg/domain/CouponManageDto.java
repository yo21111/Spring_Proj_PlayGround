package com.playground.pg.domain;


public class CouponManageDto {
	private String id;
	private String birth_month;
	private String birth_day;
	int accPrice;
	private int accTicket;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirth_month() {
		return birth_month;
	}
	public void setBirth_month(String birth_month) {
		this.birth_month = birth_month;
	}
	public String getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}
	public int getAccPrice() {
		return accPrice;
	}
	public void setAccPrice(int accPrice) {
		this.accPrice = accPrice;
	}
	public int getAccTicket() {
		return accTicket;
	}
	public void setAccTicket(int accTicket) {
		this.accTicket = accTicket;
	}
	
}
