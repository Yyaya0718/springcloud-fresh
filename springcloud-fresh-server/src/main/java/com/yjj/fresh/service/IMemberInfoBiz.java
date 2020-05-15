package com.yjj.fresh.service;

import java.util.Map;

import com.yjj.fresh.enity.MemberInfo;

public interface IMemberInfoBiz {
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
}
