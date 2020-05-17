package com.yjj.fresh.biz.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjj.fresh.biz.ICartInfoBiz;
import com.yjj.fresh.mapper.ICartInfoMapper;

@Service
public class CartInfoBizImpl implements ICartInfoBiz{

	@Autowired
	private ICartInfoMapper cartInfoMapper;

	@Override
	public int findCartNum(int mno) {
		if(mno<=0){
			return -2;
		}
		return cartInfoMapper.findCartNum(mno);
		
	}

}
