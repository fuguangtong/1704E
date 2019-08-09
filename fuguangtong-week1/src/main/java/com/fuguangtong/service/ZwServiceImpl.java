package com.fuguangtong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuguangtong.entity.T_Type;
import com.fuguangtong.entity.T_Zw;
import com.fuguangtong.entity.ZwVal;
import com.fuguangtong.mapper.ZwMapper;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */
@Service
@Transactional
public class ZwServiceImpl implements ZwService {
	@Autowired
	private ZwMapper zm;

	public List<T_Zw> selectAll(String zname) {
		// TODO Auto-generated method stub
		return zm.selectAll(zname);
	}

	public List<T_Type> selectType() {
		// TODO Auto-generated method stub
		return zm.selectType();
	}

	public int insertZw(T_Zw zw) {
		// TODO Auto-generated method stub
		return zm.insertZw(zw);
	}

	public int plDelete(ZwVal zv) {
		// TODO Auto-generated method stub
		return zm.plDelete(zv);
	}

	public T_Zw selectById(int zid) {
		// TODO Auto-generated method stub
		return zm.selectById(zid);
	}

	public int updateZw(T_Zw zw) {
		// TODO Auto-generated method stub
		return zm.updateZw(zw);
	}
}
