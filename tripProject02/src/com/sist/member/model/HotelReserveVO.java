package com.sist.member.model;

import java.util.Date;

public class HotelReserveVO {

	/*ID	NUMBER
	CHECK_IN	DATE
	CHECK_OUT	DATE
	PRICE	NUMBER
	EMAIL	VARCHAR2(45 BYTE)
	TITLE	VARCHAR2(100 BYTE)
	STATE	NUMBER*/
	
	private int id;
	private String check_in;
	private String check_out;
	private String price;
	private String email;
	private String title;
	private int state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	
}
