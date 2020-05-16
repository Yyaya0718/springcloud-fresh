package com.yjj.fresh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.enity.MemberInfo;

@RestController
@RequestMapping("/member")
public class MmeberInfoController {

	@GetMapping("/checkinfo")
	public Map<String,Object> checkInfo(HttpSession session) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		
		map.put("nickName",member.getNickName());
		map.put("cartNum",Integer.parseInt(session.getAttribute("cartNum").toString()));
		
		return map;
	}
}
