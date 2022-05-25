package com.playground.pg.domain;

// 관리자 - 예매관리, 예매 현황 에서 검색 관련 내용 Dto
public class AdminReserveDto {
	private String date1; //검색 기간1
	private String date2; // 검색 기간2
	private String criteria; // 검색 기준
	private String location; // 검색 지역
	private String exName; // 검색 전시 이름
	
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setExName(String exName) {
		this.exName = exName;
	}
	public String getDate1() {
		return date1;
	}
	public String getDate2() {
		return date2;
	}
	public String getCriteria() {
		return criteria;
	}
	public String getLocation() {
		return location;
	}
	public String getExName() {
		return exName;
	}
	
}
