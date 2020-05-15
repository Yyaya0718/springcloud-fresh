package com.yjj.fresh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.enity.MemberInfo;

@RestController
@RequestMapping("/member")
public class MmeberInfoController {

	@GetMapping("/checkinfo")
	public MemberInfo checkInfo(HttpSession session) {
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		
		if(member==null) {
			return null;
		}
		
		return member;
	}
}
