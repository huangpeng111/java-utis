package com.cy.interceptor.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.mapper.ItemMapper;
import com.cy.pojo.Item;

@Service
public class MpIpageInteceptor {
	@Autowired
	private ItemMapper itemMapper;
	
	public IPage<Item> pagInation(int current,int pageSize){
		
		IPage<Item> page = new Page<>();
		page.setCurrent(current).setSize(pageSize);
		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("created");
		IPage<Item> list = itemMapper.selectPage(page, queryWrapper);
		return list;
	}
}
