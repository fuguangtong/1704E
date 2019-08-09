package com.fuguangtong.entity;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */
public class T_Zw {
	 private int zid;
	 private String zname;
	 private String zms;
	 private T_Type type;
	@Override
	public String toString() {
		return "T_Zw [zid=" + zid + ", zname=" + zname + ", zms=" + zms + ", type=" + type + "]";
	}
	public T_Zw() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public String getZms() {
		return zms;
	}
	public void setZms(String zms) {
		this.zms = zms;
	}
	public T_Type getType() {
		return type;
	}
	public void setType(T_Type type) {
		this.type = type;
	}
	
	 
}
