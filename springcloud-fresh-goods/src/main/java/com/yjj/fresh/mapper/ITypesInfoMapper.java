package com.yjj.fresh.mapper;

import java.util.List;

import com.yjj.fresh.enity.TypeInfo;


public interface ITypesInfoMapper {
	
	/**
	 * 查询所有类型
	 * @return
	 */
	public List<TypeInfo> finds();
}
