package com.cy.mapper;

import com.cy.pojo.school;

public interface schoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(school record);

    int insertSelective(school record);

    school selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(school record);

    int updateByPrimaryKey(school record);
}