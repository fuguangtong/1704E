package com.fuguangtong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuguangtong.entity.T_Type;
import com.fuguangtong.entity.T_Zw;
import com.fuguangtong.entity.ZwVal;
import com.fuguangtong.service.ZwService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @作者:付广通
 * @时间:2019年8月6日
 */

@Controller
public class ZwController {
	@Autowired
	private ZwService service;
	//查看跳转
	@RequestMapping("chakan.do")
	public String chaKan(Model model,int zid){
		model.addAttribute("zid", zid);
		return "chakan";
	}
	//修改
	@RequestMapping("updates.do")
	@ResponseBody
	public boolean updateS(T_Zw zw){
		int flag = service.updateZw(zw);
		if(flag>0){
			return true;
		}else{
			return false;
			
		}
	}
	//修改回显
	@RequestMapping("show.do")
	@ResponseBody	
	public T_Zw show(int zid){
		T_Zw zw = service.selectById(zid);
		return zw;
		
	}
	//修改跳转
	@RequestMapping("update.do")
	public String update(Model model,int zid){
		model.addAttribute("zid", zid);
		return "update";
	}
	//批量删除
	@RequestMapping("pldelete.do")
	@ResponseBody	
	public boolean plDelete(ZwVal zw){
		int flag = service.plDelete(zw);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}
	//添加
	@RequestMapping("adds.do")
	@ResponseBody
	public boolean addS(T_Zw zw){
		int flag = service.insertZw(zw);
		if(flag>0){
			return true;
		}else{
			return false;
			
		}
	}
	//实现动态追加下拉框
	@RequestMapping("xiala.do")
	@ResponseBody
	public List<T_Type> xiaLa(){
		List<T_Type> tlist = service.selectType();
		return tlist;
		
	}
	//转发添加页面
	@RequestMapping("add.do")
	public String add(){
		return "add";
	}
	//列表
	@RequestMapping("list.do")
	public String selectAll(Model model,String zname,@RequestParam(defaultValue="1")int pageNum){
		int pageSize=2;
		PageHelper.startPage(pageNum, pageSize);
		List<T_Zw> zlist = service.selectAll(zname);
		PageInfo<T_Zw> plist = new PageInfo<T_Zw>(zlist);
		model.addAttribute("zlist", zlist);
		model.addAttribute("zname", zname);
		model.addAttribute("plist", plist);
		return "list";
		
	}
}
