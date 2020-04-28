package com.sist.attraction.vo;

public class AttractionDetailVO {
/*
 * 
 * * 이름                널?       유형             
----------------- -------- -------------- 
ID                NOT NULL NUMBER         
TITLE                      VARCHAR2(200)  
PRODUCT_KIND     [          VARCHAR2(50)   
HASH_TAG                   VARCHAR2(300)  
INTRODUCTION               VARCHAR2(1200) 
EVEL_POINT                 NUMBER         
WEB_SITE                   VARCHAR2(500)  
DESCRIPTION                CLOB           
CONVENIENCE                VARCHAR2(500)  
ADDRESS                    VARCHAR2(500)  
ROAD_ADDRESS               VARCHAR2(500)  
TEL                        VARCHAR2(100)  
LONGITUDE                  VARCHAR2(100)  
LATITUDE                   VARCHAR2(100)  
SHORT_DESCRIPTION          CLOB           
THUMBNAIL                  VARCHAR2(1000) 
REVIEW_COUNT               NUMBER         
 * 
 * 
 * 
 * 
 */
	private int id;
	private String title;
	private String thumb;
	private String web;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getConvenience() {
		return convenience;
	}
	public void setConvenience(String convenience) {
		this.convenience = convenience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoad_address() {
		return road_address;
	}
	public void setRoad_address(String road_address) {
		this.road_address = road_address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String convenience;
	private String address;
	private String road_address;
	private String tel;
	private String attrmake;
	public String getAttrmake() {
		return attrmake;
	}
	public void setAttrmake(String attrmake) {
		this.attrmake = attrmake;
	}
	
}
