package com.cy.mapper;

import com.cy.pojo.grade;

public interface gradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(grade record);

    int insertSelective(grade record);

    grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(grade record);

    int updateByPrimaryKey(grade record);
}