package com.cy.mapper;

import com.cy.pojo.clazz;

public interface clazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(clazz record);

    int insertSelective(clazz record);

    clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(clazz record);

    int updateByPrimaryKey(clazz record);
}