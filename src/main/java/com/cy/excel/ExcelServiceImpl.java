package com.cy.excel;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.mapper.ItemMapper;
import com.cy.pojo.Item;

@Service
public class ExcelServiceImpl implements ExcelService{
	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> findAll(){
		return itemMapper.selectList(null);
	}
}
