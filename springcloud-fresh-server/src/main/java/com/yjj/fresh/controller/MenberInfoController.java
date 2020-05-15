package com.yjj.fresh.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.enity.MemberInfo;
import com.yjj.fresh.service.IMemberInfoBiz;
import com.yjj.fresh.util.ResponseUtil;
import com.yjj.fresh.util.SendMailUtil;
@RestController
@RequestMapping("/member")
public class MenberInfoController {

	@Autowired
	private SendMailUtil sendMailUtil;

	@Autowired
	private IMemberInfoBiz memberInfoBiz;

	@RequestMapping("/login")
	@ResponseBody
	public int Login(@RequestParam Map<String,Object> map,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		int result=-1;
		MemberInfo member=memberInfoBiz.login(map);

		if(member!=null){
			if(member.getStatus()==1){
				session.setAttribute("LoginUser", member);
				result=2;
			}else{
				result=-3;
			}
		}

		return result;
	}

	@RequestMapping("/reg")
	@ResponseBody
	public int reg(HttpSession session ,MemberInfo member){
		//取出验证码，判断验证码是否正确
		String code=session.getAttribute("GetCode").toString();
		if("".equals(code) || code==""){
			return -2;//验证码过期
		}

		if(!member.getCode().equals(code)){
			return -3;//验证码错误
		}

		return memberInfoBiz.reg(member);
	}


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
