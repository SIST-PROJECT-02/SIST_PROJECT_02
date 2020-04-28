package com.sist.hotel.dao;

import java.util.Date;

public class ProductRoomsAvailableVO {
	private int id;
	private int hotel_id;
	private int room_no;
	private Date regdate;
	private String is_reserved;
	private int addDate;

	public int getAddDate() {
		return addDate;
	}

	public void setAddDate(int addDate) {
		this.addDate = addDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getIs_reserved() {
		return is_reserved;
	}

	public void setIs_reserved(String is_reserved) {
		this.is_reserved = is_reserved;
	}

}
