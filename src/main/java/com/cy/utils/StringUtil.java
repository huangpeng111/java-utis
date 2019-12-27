package com.cy.utils;

import java.util.Date;
import java.util.List;

/**
 * ʵ�ù�����
 * @author 20180877
 *
 */
public class StringUtil {
	/**
	 * ��������list����ָ���ķָ����ָ���ַ���������һ��ɾ����������ʱ����Ҫ��������
	 * @param list
	 * @param split
	 * @return
	 */
	//��List����Ҫ��ķָ������ָ�󷵻�,split������ʾ��һ���ַ����ָ�ɷ������飬����"2:3:4:5".split(":")	//������["2", "3", "4", "5"]
	public static String joinString(List<Long> list,String split) {
		String ret = "";
		for(Long l:list) {
			ret += l + split;
		}
		//ret���滹�б������
		if (!"".equals(ret)) {
			ret = ret.substring(0,ret.length() - split.length());
		}
		return ret;
	}
	
	//����ѧ��
	public static String generateSn(String prefix,String suffix) {
		return prefix + new Date().getTime() + suffix;
	}
}
