package com.fuguangtong.entity;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */
public class T_Type {
	private int tid;
	private String tname;
	@Override
	public String toString() {
		return "T_Type [tid=" + tid + ", tname=" + tname + "]";
	}
	public T_Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
