package com.yjj.fresh.biz;


public interface ICartInfoBiz {

	/**
	 * 根据会员号查询购物车商品数量
	 * @param mno
	 * @return
	 */
	public int findCartNum(int mno);
	
	
}
