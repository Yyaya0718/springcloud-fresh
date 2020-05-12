package com.yjj.fresh.user.controller;

import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.user.util.ResponseUtil;
import com.yjj.fresh.user.util.SendMailUtil;
@RestController
@RequestMapping("/member")
public class MenberInfoController {

	@Autowired
	private SendMailUtil sendMailUtil;
	
	@RequestMapping("email")
	public Map<String,Object> sendCode(HttpSession session,String uname,String email) {
		String code="";
		Random r=new Random();
		while(code.length()<6) {
			code+=r.nextInt(10);
		}
		if(sendMailUtil.sendHtmlMail(email, uname, code)) {
			session.setAttribute("emailCode", code);
			
			TimerTask task=new TimerTask() {

				@Override
				public void run() {
					session.removeAttribute("emailCode");
					
				}
			};
			
			Timer timer=new Timer();
			timer.schedule(task, 180000);
			
			return ResponseUtil.responseMap(200, null, null);
		}
		return ResponseUtil.responseMap(500, null, null);
	}
}
