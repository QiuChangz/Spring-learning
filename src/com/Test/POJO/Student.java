package com.Test.POJO;

public class Student {

	private int id,sid;
	private String sname,tname,area,profession;
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setSid(int sid){
		this.sid = sid;
	}
	
	public void setSname(String sname){
		this.sname = sname;
	}
	
	public void setTname(String tname){
		this.tname = tname;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	
	public void setProfession(String profession){
		this.profession = profession;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getSid(){
		return this.sid;
	}
	
	public String getSname(){
		return this.sname;
	}
	
	public String getTname(){
		return this.tname;
	}
	
	public String getArea(){
		return this.area;
	}
	
	public String getProfession(){
		return this.profession;
	}
}
