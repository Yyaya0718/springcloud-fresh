package com.yjj.fresh.mapper;


public interface ICartInfoMapper {
	/**
	 * 根据会员号查询购物车商品数量
	 * @param mno
	 * @return
	 */
	public int findCartNum(int mno);
	
	
}
