package com.sist.airplane.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 	RNO           NOT NULL NUMBER        
	EMAIL                  VARCHAR2(300) 
	NAME                   VARCHAR2(300) 
	PLANE_ID      NOT NULL NUMBER        
	AIRLINE       NOT NULL VARCHAR2(30)  
	AIRWAY        NOT NULL VARCHAR2(30)  
	START_AIRPORT NOT NULL VARCHAR2(30)  
	END_AIRPORT   NOT NULL VARCHAR2(30)  
	START_TIME    NOT NULL DATE          
	END_TIME      NOT NULL DATE          
	START_HOUR    NOT NULL VARCHAR2(30)  
	END_HOUR      NOT NULL VARCHAR2(30)  
	TOTAL_TIME    NOT NULL VARCHAR2(30)  
	SEATTYPE      NOT NULL NUMBER        
	PRICE         NOT NULL VARCHAR2(30)  
	IMG           NOT NULL VARCHAR2(100) 
	INWON                  NUMBER        
	STATUS                 NUMBER        
 */
@Getter
@Setter
public class AirplaneReserveVO {
	private int rno;
	private String email;
	private String name;
	private int plane_id;
	private String airline;
	private String airway;
	private String start_airport;
	private String end_airport;
	private String start_time;
	private Date end_time;
	private String start_hour;
	private String end_hour;
	private String total_time;
	private int seattype;
	private String price;
	private String img;
	private int inwon;
	private int status;
	private String date;
	private String day;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getEmail() {
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
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getAirway() {
		return airway;
	}
	public void setAirway(String airway) {
		this.airway = airway;
	}
	public String getStart_airport() {
		return start_airport;
	}
	public void setStart_airport(String start_airport) {
		this.start_airport = start_airport;
	}
	public String getEnd_airport() {
		return end_airport;
	}
	public void setEnd_airport(String end_airport) {
		this.end_airport = end_airport;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}
	public String getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}
	public String getTotal_time() {
		return total_time;
	}
	public void setTotal_time(String total_time) {
		this.total_time = total_time;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
