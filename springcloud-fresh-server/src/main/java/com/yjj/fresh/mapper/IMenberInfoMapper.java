package com.yjj.fresh.mapper;

import java.util.Map;

import com.yjj.fresh.enity.MemberInfo;

public interface IMenberInfoMapper {

	/**
	 * 登录操作
	 * @param map
	 * @return
	 */
	public MemberInfo login(Map<String,Object> map);

	/**
	 * 注册
	 */
	public int reg(MemberInfo member);
	
	/**
	 * 根据会员号查询购物车商品数量
	 * @param mno
	 * @return
	 */
	public int findCartNum(int mno);
}
