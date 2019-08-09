package com.fuguangtong.entity;

import java.util.Arrays;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */
public class ZwVal {
	private String[] zid;

	@Override
	public String toString() {
		return "ZwVal [zid=" + Arrays.toString(zid) + "]";
	}

	public ZwVal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String[] getZid() {
		return zid;
	}

	public void setZid(String[] zid) {
		this.zid = zid;
	}
	
}
