package com.bdqn.oa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.TypeConstraintException;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConvert extends StrutsTypeConverter {
	@Override								 //可以接受多个
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("进入 转换器--------");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;									
		
		try {
			date=sdf.parse(arg1[0]);
			
		} catch (ParseException e) {
			throw new TypeConstraintException("转化日期失败！！");	//自定义异常
		}
		return date;
	}

	//显示
	@Override
	public String convertToString(Map arg0, Object arg1) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		return sdf.format(arg1);
	}
}
