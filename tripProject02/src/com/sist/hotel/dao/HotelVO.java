package com.sist.hotel.dao;

/*
 * ID                NOT NULL NUMBER         
TITLE                      VARCHAR2(200)  
PRODUCT_KIND               VARCHAR2(50)   
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
 */
public class HotelVO {
	private int id;
	private String title, product_kind, hash_tag, introduction, web_site, description, convenience, address,
			road_address, tel, longitude, latitude, short_description, thumbnail;
	private double evel_point;

	
	
	public HotelVO(int id, String title, String product_kind, String hash_tag, String introduction, String web_site,
			String description, String convenience, String address, String road_address, String tel, String longitude,
			String latitude, String short_description, String thumbnail, double evel_point) {
		super();
		this.id = id;
		this.title = title;
		this.product_kind = product_kind;
		this.hash_tag = hash_tag;
		this.introduction = introduction;
		this.web_site = web_site;
		this.description = description;
		this.convenience = convenience;
		this.address = address;
		this.road_address = road_address;
		this.tel = tel;
		this.longitude = longitude;
		this.latitude = latitude;
		this.short_description = short_description;
		this.thumbnail = thumbnail;
		this.evel_point = evel_point;
	}
	public HotelVO(){
		super();
	}

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

	public String getProduct_kind() {
		return product_kind;
	}

	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}

	public String getHash_tag() {
		return hash_tag;
	}

	public void setHash_tag(String hash_tag) {
		this.hash_tag = hash_tag;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getWeb_site() {
		return web_site;
	}

	public void setWeb_site(String web_site) {
		this.web_site = web_site;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public double getEvel_point() {
		return evel_point;
	}

	public void setEvel_point(double evel_point) {
		this.evel_point = evel_point;
	}

}
