/**
 * 
 */
package com.spz.bdqn.house.ssh.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * @���� bdqn_house
 * @���� ʩ����
 * @�������� 2017��12��20��
 * @����ʱ�� ����2:09:37
 */
public class DateConverter extends StrutsTypeConverter {

	// ֧��ת���Ķ������ڸ�ʽ,������ʱ���ʽ
		private final DateFormat[] dfs = { 
				//new SimpleDateFormat("yyyy��MM��dd��"),
				new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("MM/dd/yy"),
				new SimpleDateFormat("yyyy.MM.dd"), 
				new SimpleDateFormat("yyMMdd"),
				new SimpleDateFormat("yyyy/MM/dd") };

		/**
		 * ��ָ����ʽ�ַ���ת��Ϊ�������͡�
		 */
		public Object convertFromString(Map context, String[] values, Class toType) {
			String dateStr = values[0];// ��ȡ���ڵ��ַ���
			for (int i = 0; i < dfs.length; i++) {// ��������֧�ָ�ʽ,����ת��
				try {
					return dfs[i].parse(dateStr);
				} catch (Exception e) {
					continue;
				}
			}
			throw new TypeConversionException("ת������");
		}

		public String convertToString(Map context, Object object) {
			Date date = (Date) object;
			// ����ĸ�ʽ��yyyy-MM-dd
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
}
