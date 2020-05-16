package com.yjj.fresh.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.fresh.biz.IGoodsInfoBiz;
import com.yjj.fresh.enity.GoodsInfo;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {

	@Autowired
	private IGoodsInfoBiz goodInfoBiz;

	@RequestMapping("finds")
	public Map<String,Object> findGood(){
		return goodInfoBiz.finds();
	}

	/**
	 * 根据tid分页查询商品信息
	 * @param tno
	 * @return
	 */
	@RequestMapping("/findByPage")
	public Map<String,Object> findByPage(@RequestParam Map<String,Object> map){
		if(goodInfoBiz.findByPage(map)==null){
			return null;
		}else{
			return goodInfoBiz.findByPage(map);
		}
	}

	@RequestMapping("/findByGno")
	public GoodsInfo findByGno(String gno){
		return goodInfoBiz.fingByGno(gno);
	}
}
