package com.sist.airplane.dao;


/*
 	NO       NOT NULL VARCHAR2(100) 
	PLANE_ID NOT NULL NUMBER        
	TYPE              NUMBER        
	PRICE             VARCHAR2(100) 
	CHECKED           NUMBER   
 */

public class AirplaneSeatVO {
	private String no;
	private int plane_id;
	private int seattype;
	private String price;
	private int checked;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public int getSeattype() {
		return seattype;
	}
	public void setSeattype(int seattype) {
		this.seattype = seattype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	
}
