package com.book.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
   * ʵ�����ڸ�ʽDate������String֮����໥ת��
 */
public class DateTool {
	//��̬��Ա��������ӵ�еģ�����Դ�����
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//���ַ���ת����
	public static Date stringToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	//������ת�ַ���
	public static String dateToString(Date dt) {
		return sdf.format(dt);
	}
}
