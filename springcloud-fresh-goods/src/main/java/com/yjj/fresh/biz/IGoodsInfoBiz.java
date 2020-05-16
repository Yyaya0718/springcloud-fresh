package com.yjj.fresh.biz;

import java.util.Map;

import com.yjj.fresh.enity.GoodsInfo;

public interface IGoodsInfoBiz {
	/**
	 * 查询所有商品的种类,和所有种类
	 * @return
	 */
	public Map<String,Object> finds();
	
	/**
	 * 根据类型分页查询商品
	 */
	public Map<String,Object> findByPage(Map<String,Object> maps);
	/**
	 * 根据商品编号查询商品的详细信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo fingByGno(String gno);
}
