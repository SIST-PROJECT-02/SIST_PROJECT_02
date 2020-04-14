package com.sist.board.dao;

import java.util.*;

public class ReplyVO {
	private int no;
	private int bno;
	private String id;
	private String name;
	private String msg;
	private Date regdate;
	public int getNo() {
		return no;
	}
	public int getBno() {
		return bno;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMsg() {
		return msg;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
