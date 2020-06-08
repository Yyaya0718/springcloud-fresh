package com.yjj.fresh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.biz.IAddrInfoBiz;
import com.yjj.fresh.enity.AddrInfo;
import com.yjj.fresh.enity.MemberInfo;

@RestController
@RequestMapping("/addr")
public class AddrInfoController {

	@Autowired
	private IAddrInfoBiz addrInfoBiz;
	
	
	@RequestMapping("/add")
	public int addAddr(HttpSession session,AddrInfo addr){
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		if(member==null){
			return -3;
		}
		addr.setMno(member.getMno());
		return addrInfoBiz.add(addr);
	}
	
	@RequestMapping("/defalut")
	public int setDefalutAddr(String ano,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ano", ano);
		map.put("mno",((MemberInfo) session.getAttribute("LoginUser")).getMno());
		return addrInfoBiz.setDefault(map);
	}
}
