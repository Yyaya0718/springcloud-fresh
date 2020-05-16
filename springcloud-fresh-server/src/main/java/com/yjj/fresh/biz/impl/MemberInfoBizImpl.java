package com.yjj.fresh.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjj.fresh.biz.IMemberInfoBiz;
import com.yjj.fresh.enity.MemberInfo;
import com.yjj.fresh.mapper.IMenberInfoMapper;
import com.yjj.fresh.util.StringUtil;

@Service
public class MemberInfoBizImpl implements IMemberInfoBiz{
	@Autowired
	private IMenberInfoMapper memberInfoMapper;

	@Override
	public MemberInfo login(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("nickName"),map.get("pwd"))){
			return null;
		}
		return memberInfoMapper.login(map);
	}

	

	@Override
	public int findCartNum(int mno) {
		if(mno<=0){
			return -2;
		}
		return memberInfoMapper.findCartNum(mno);
		
	}
	
	@Override
	public int reg(MemberInfo member) {
		if(StringUtil.checkNull(member.getNickName(),member.getPwd(),member.getEmail())){
			return -4;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		String regDate=sdf.format(d);
		member.setRegDate(regDate);
		
		return memberInfoMapper.reg(member);
	}
}
