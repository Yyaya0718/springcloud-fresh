package com.yjj.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yjj.fresh.enity.GoodsInfo;


public interface IGoodsInfoMapper {

	/**
	 * 查询所有商品信息
	 * @return
	 */
	public List<GoodsInfo> finds();
	
	/**
	 * 根据类型分页查询商品
	 */
	public List<GoodsInfo> findByPage(Map<String,Object> map);
	
	/**
	 * 查询某种类型的数据条数
	 */
	public int findByTno(String tno);
	
	/**
	 * 根据商品编号查询商品的详细信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo fingByGno(String gno);
}
