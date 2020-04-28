package com.sist.attraction.vo;

/*
 * 
 * 
 * 이름                널?       유형             
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
 */
public class AttractionVO {

	private int id;
	private String title;
	private String kind;
	private String hash;
	private String introduction;
	private int evel_point;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getEvel_point() {
		return evel_point;
	}
	public void setEvel_point(int evel_point) {
		this.evel_point = evel_point;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	private String thumb;
	
	
	
	
}
