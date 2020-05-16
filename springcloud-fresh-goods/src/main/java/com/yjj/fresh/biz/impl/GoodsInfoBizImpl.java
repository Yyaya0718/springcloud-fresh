package com.yjj.fresh.biz.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjj.fresh.biz.IGoodsInfoBiz;
import com.yjj.fresh.enity.GoodsInfo;
import com.yjj.fresh.enity.TypeInfo;
import com.yjj.fresh.mapper.IGoodsInfoMapper;
import com.yjj.fresh.mapper.ITypesInfoMapper;
import com.yjj.fresh.util.StringUtil;


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
	@Override
	public Map<String, Object> findByPage(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("tno"),map.get("page"))){
			return Collections.emptyMap();
		}

		Map<String,Object> result=new HashMap<String,Object>();
		Map<String,Object> param=new HashMap<String,Object>();
		int page=Integer.parseInt(map.get("page").toString());
		int rows=10;
		param.put("tno", map.get("tno"));
		param.put("page", (page-1)*rows);
		param.put("rows", rows);

		//获取分页查询的商品结果
		List<GoodsInfo> goods=goodsInfoMapper.findByPage(param);
		//获取总记录数量
		int pages=goodsInfoMapper.findByTno(String.valueOf(map.get("tno")));
		pages=pages%rows>0 ? (pages/rows)+1 : pages/rows;

		result.put("goodsInfo", goods);
		result.put("pages", pages);

		return result;
	}

	@Override
	public GoodsInfo fingByGno(String gno) {
		if(StringUtil.checkNull(gno)){
			return null;
		}

		return goodsInfoMapper.fingByGno(gno);
	}
}
