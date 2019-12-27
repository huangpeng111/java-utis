package com.cy.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.pojo.Item;
@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    
}