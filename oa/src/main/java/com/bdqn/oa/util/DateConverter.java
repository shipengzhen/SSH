/**
 * 
 */
package com.bdqn.oa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * @描述 日期格式转换类
 * @作者 施鹏振
 * @创建日期 2017年12月26日
 * @创建时间 上午11:23:28
 */
public class DateConverter extends StrutsTypeConverter {

	// 支持转换的多种日期格式,可增加时间格式
		private final DateFormat[] dfs = { 
				//new SimpleDateFormat("yyyy年MM月dd日"),
				new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("MM/dd/yy"),
				new SimpleDateFormat("yyyy.MM.dd"), 
				new SimpleDateFormat("yyMMdd"),
				new SimpleDateFormat("yyyy/MM/dd") };

		/**
		 * 将指定格式字符串转换为日期类型。
		 */
		public Object convertFromString(Map context, String[] values, Class toType) {
			String dateStr = values[0];// 获取日期的字符串
			for (int i = 0; i < dfs.length; i++) {// 遍历日期支持格式,进行转换
				try {
					return dfs[i].parse(dateStr);
				} catch (Exception e) {
					continue;
				}
			}
			throw new TypeConversionException("转换错误");
		}

		public String convertToString(Map context, Object object) {
			Date date = (Date) object;
			// 输出的格式是yyyy-MM-dd
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
}
