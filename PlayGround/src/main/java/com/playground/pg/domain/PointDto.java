package com.playground.pg.domain;

public class PointDto {
	private int no;
	private String id_FK;
	private Integer point;
	private String pointDate;
	private String pointContent = "전시 예매 적립금 적립";

	
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
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getPointDate() {
		return pointDate;
	}
	public void setPointDate(String pointDate) {
		this.pointDate = pointDate;
	}
	public String getPointContent() {
		return pointContent;
	}
	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}
	
}
