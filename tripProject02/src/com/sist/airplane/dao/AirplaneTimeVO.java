package com.sist.airplane.dao;
/*
 	NO            NOT NULL NUMBER       
	PLANE_ID      NOT NULL NUMBER       
	START_TIME    NOT NULL DATE         
	END_TIME      NOT NULL DATE         
	START_AIRPORT NOT NULL VARCHAR2(20) 
	END_AIRPORT   NOT NULL VARCHAR2(20) 
 */
import java.util.*;



public class AirplaneTimeVO {
	private int no;
	private int plane_id;
	private Date start_time;
	private Date end_time;
	private String start_airport;
	private String end_airport;
	private String totaltime;
	private String start_hour;
	private String end_hour;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
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
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
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
	
	
	
	
}
