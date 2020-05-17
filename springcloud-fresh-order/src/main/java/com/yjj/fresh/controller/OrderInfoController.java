package com.yjj.fresh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.biz.ICartInfoBiz;
import com.yjj.fresh.biz.IOrderInfoBiz;
import com.yjj.fresh.enity.MemberInfo;
import com.yjj.fresh.enity.OrderInfo;

@RestController
@RequestMapping("/order")
public class OrderInfoController {

	@Autowired
	private IOrderInfoBiz orderInfoBiz;
	
	@Autowired
	private ICartInfoBiz cartInfoBiz;
	
	@RequestMapping("/finds")
	public Map<String,Object> findAll(HttpSession session,String gnos){
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		int mno=member.getMno();
		return orderInfoBiz.findAll(gnos, mno);
	}
	
	@RequestMapping("/pay")
	public int orderPay(@RequestParam Map<String,Object> map,HttpSession session){
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		map.put("mno", member.getMno());
		int result=orderInfoBiz.orderPay(map);
		if(result>0){
			session.setAttribute("cartNum", cartInfoBiz.findCartNum(Integer.parseInt(map.get("mno").toString())));
		}
		return result;
	}
	
	@RequestMapping("/findall")
	public List<OrderInfo> findAll(HttpSession session){
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		return orderInfoBiz.findByPage(member.getMno());
	}
	
	
}
