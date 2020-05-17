package com.yjj.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yjj.fresh.enity.GoodsInfo;

public interface IGoodsInfoMapper {
	
	/**
	 * 根据订单表中的gnos查询商品信息
	 * @param array
	 * @return
	 */
	public List<GoodsInfo> findOrder(String[] array);
	
	public List<GoodsInfo> find(Map<String,Object> map);
}
