package com.sist.board.dao;
import java.util.*;


public class BoardVO {
   private int no;
   private String name;
   private String subject;
   private String content;
   private String pwd;
   private Date regdate;
   private int hit;
   private int group_id;
   private int group_step;
   private int group_tab;
   private int root;
   private int depth;
   private String filename;
   private String filesize;
   private int type;
   
   private String dbday;
public String getDbday() {
	return dbday;
}
public void setDbday(String dbday) {
	this.dbday = dbday;
}
public int getNo() {
	return no;
}
public String getName() {
	return name;
}
public String getSubject() {
	return subject;
}
public String getContent() {
	return content;
}
public String getPwd() {
	return pwd;
}
public Date getRegdate() {
	return regdate;
}
public int getHit() {
	return hit;
}
public int getGroup_id() {
	return group_id;
}
public int getGroup_step() {
	return group_step;
}
public int getGroup_tab() {
	return group_tab;
}
public int getRoot() {
	return root;
}
public int getDepth() {
	return depth;
}
public String getFilename() {
	return filename;
}
public String getFilesize() {
	return filesize;
}
public int getType() {
	return type;
}
public void setNo(int no) {
	this.no = no;
}
public void setName(String name) {
	this.name = name;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public void setContent(String content) {
	this.content = content;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public void setHit(int hit) {
	this.hit = hit;
}
public void setGroup_id(int group_id) {
	this.group_id = group_id;
}
public void setGroup_step(int group_step) {
	this.group_step = group_step;
}
public void setGroup_tab(int group_tab) {
	this.group_tab = group_tab;
}
public void setRoot(int root) {
	this.root = root;
}
public void setDepth(int depth) {
	this.depth = depth;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public void setFilesize(String filesize) {
	this.filesize = filesize;
}
public void setType(int type) {
	this.type = type;
}
   
   
   
}