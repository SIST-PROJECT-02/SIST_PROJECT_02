package com.sist.airplane.dao;


/*
 	PLANE_ID NOT NULL NUMBER       
	FIRST    NOT NULL NUMBER       
	BUSINESS NOT NULL NUMBER       
	ECONOMY  NOT NULL NUMBER       
	SIZETYPE NOT NULL NUMBER       
	AIRLINE  NOT NULL VARCHAR2(20) 
 */
public class AirplaneVO {
	private int plane_id;
	private int first;
	private int business;
	private int economy;
	private int sizeType;
	private String img;
	private String airline;
/*	private String email;
	private String name;*/
	private AirplaneSeatVO seatVO = new AirplaneSeatVO();
	private AirplaneTimeVO timeVO = new AirplaneTimeVO();
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getBusiness() {
		return business;
	}
	public void setBusiness(int business) {
		this.business = business;
	}
	public int getEconomy() {
		return economy;
	}
	public void setEconomy(int economy) {
		this.economy = economy;
	}
	public int getSizeType() {
		return sizeType;
	}
	public void setSizeType(int sizeType) {
		this.sizeType = sizeType;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public AirplaneSeatVO getSeatVO() {
		return seatVO;
	}
	public void setSeatVO(AirplaneSeatVO seatVO) {
		this.seatVO = seatVO;
	}
	public AirplaneTimeVO getTimeVO() {
		return timeVO;
	}
	public void setTimeVO(AirplaneTimeVO timeVO) {
		this.timeVO = timeVO;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
/*	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	
	
	
}
