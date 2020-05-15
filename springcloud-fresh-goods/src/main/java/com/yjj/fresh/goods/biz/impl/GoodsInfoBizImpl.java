package com.yjj.fresh.goods.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjj.fresh.goods.biz.IGoodsInfoBiz;
import com.yjj.fresh.goods.enity.GoodsInfo;
import com.yjj.fresh.goods.enity.TypeInfo;
import com.yjj.fresh.goods.mapper.IGoodsInfoMapper;
import com.yjj.fresh.goods.mapper.ITypesInfoMapper;


@Service
public class GoodsInfoBizImpl implements IGoodsInfoBiz{

	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;
	
	@Autowired
	private ITypesInfoMapper typeInfoMapper;
	
	@Override
	public Map<String,Object> finds() {
		
		List<GoodsInfo> goodsInfo=goodsInfoMapper.finds();
		List<TypeInfo> typeInfo=typeInfoMapper.finds();
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("goods", goodsInfo);
		map.put("types", typeInfo);
		return map;
	}

}
