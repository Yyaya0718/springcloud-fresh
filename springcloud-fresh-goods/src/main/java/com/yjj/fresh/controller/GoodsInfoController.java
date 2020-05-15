package com.yjj.fresh.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.biz.IGoodsInfoBiz;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {

	@Autowired
	private IGoodsInfoBiz goodInfoBiz;

	@RequestMapping("finds")
	public Map<String,Object> findGood(){
		return goodInfoBiz.finds();
	}


}
