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
	
	
	
}
