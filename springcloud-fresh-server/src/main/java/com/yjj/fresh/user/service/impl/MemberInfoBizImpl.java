package com.yjj.fresh.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjj.fresh.user.enity.MemberInfo;
import com.yjj.fresh.user.mapper.IMenberInfoMapper;
import com.yjj.fresh.user.service.IMemberInfoBiz;
import com.yjj.fresh.user.util.StringUtil;

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
