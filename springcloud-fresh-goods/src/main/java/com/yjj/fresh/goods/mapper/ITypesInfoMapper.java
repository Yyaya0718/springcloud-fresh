package com.yjj.fresh.goods.mapper;

import java.util.List;

import com.yjj.fresh.goods.enity.TypeInfo;


public interface ITypesInfoMapper {
	
	/**
	 * 查询所有类型
	 * @return
	 */
	public List<TypeInfo> finds();
}
