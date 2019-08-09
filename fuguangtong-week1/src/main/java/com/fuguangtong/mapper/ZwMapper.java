package com.fuguangtong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fuguangtong.entity.T_Type;
import com.fuguangtong.entity.T_Zw;
import com.fuguangtong.entity.ZwVal;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */
public interface ZwMapper {
	//修改
	int updateZw(T_Zw zw);
	//修改回显
	T_Zw selectById(@Param("zid")int zid);
	//批量删除
	int plDelete(ZwVal zv);
	//添加
	int insertZw(T_Zw zw);
	//下拉框追加
	List<T_Type> selectType();
	//查询全部，列表展示
	List<T_Zw> selectAll(@Param("zname")String zname);
}
