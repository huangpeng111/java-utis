package com.cy.utils;

import java.util.Date;
import java.util.List;

/**
 * 实用工具类
 * @author 20180877
 *
 */
public class StringUtil {
	/**
	 * 将给定的list按照指定的分隔符分割成字符串，比如一次删除多条数据时就需要遍历数据
	 * @param list
	 * @param split
	 * @return
	 */
	//把List按照要求的分隔符来分割后返回,split函数表示把一个字符串分割成符串数组，例如"2:3:4:5".split(":")	//将返回["2", "3", "4", "5"]
	public static String joinString(List<Long> list,String split) {
		String ret = "";
		for(Long l:list) {
			ret += l + split;
		}
		//ret里面还有别的内容
		if (!"".equals(ret)) {
			ret = ret.substring(0,ret.length() - split.length());
		}
		return ret;
	}
	
	//生成学号
	public static String generateSn(String prefix,String suffix) {
		return prefix + new Date().getTime() + suffix;
	}
}
