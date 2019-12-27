package com.cy.page;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cy.interceptor.mp.MpIpageInteceptor;
import com.cy.pojo.Item;

/**
 * mp分页测试	
 * 
 * @author 000
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageTest {
	@Autowired
	private MpIpageInteceptor mp;
	
	@Test
	public void tes() {
		IPage<Item> list = mp.pagInation(0, 10);
		System.err.println("----------------");
		System.out.println(list.getRecords());
		System.out.println(list.getTotal());
		System.out.println(list.getPages());
		System.out.println(list.getSize());
	}
	
}
