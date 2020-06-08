package com.yjj.fresh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yjj.fresh.biz.IOrderInfoBiz;
import com.yjj.fresh.enity.MemberInfo;
import com.yjj.fresh.util.ApplicationConfig;

@RestController
@RequestMapping("/apli")
public class ApliConfigController {

	@Autowired
	private IOrderInfoBiz orderInfo;
	

	@RequestMapping("/pay/{ono}/{price}")		//踩坑记录->这里不可直接return result; 必须要response.getWriter().print(result);或者以map键值对方法返回
	public void toPay(@PathVariable String ono,@PathVariable double price,HttpServletRequest request,HttpServletResponse resp,HttpSession session) throws AlipayApiException, IOException, ServletException {

		session.setAttribute("ono", ono);

		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(ApplicationConfig.gatewayUrl, ApplicationConfig.app_id, ApplicationConfig.merchant_private_key, "json", ApplicationConfig.charset, ApplicationConfig.alipay_public_key, ApplicationConfig.sign_type);

		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(ApplicationConfig.return_url);
		alipayRequest.setNotifyUrl(ApplicationConfig.notify_url);

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ono +"\"," 
				+ "\"total_amount\":\""+ price +"\"," 
				+ "\"subject\":\""+ " 天天生鲜支付 " +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		resp.getWriter().print(result);
	}

	@RequestMapping("/return")
    public void toIndex(HttpServletResponse resp,HttpSession session) throws IOException{
		String ono=session.getAttribute("ono").toString();
		orderInfo.update(ono);
		MemberInfo member=(MemberInfo) session.getAttribute("LoginUser");
		PrintWriter out = resp.getWriter();
		out.print("<script>location.href='/order/order.html'</script>");
		session.setAttribute("LoginUser", member);
    }
}
