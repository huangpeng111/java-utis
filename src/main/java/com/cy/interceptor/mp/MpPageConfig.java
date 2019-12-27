package com.cy.interceptor.mp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * mp分页插件配置
 * @author 000
 *
 */
@Configuration
public class MpPageConfig {
	
	@Bean
	public PaginationInterceptor page() {
		PaginationInterceptor pa = new PaginationInterceptor();
		return pa;
	}

}
