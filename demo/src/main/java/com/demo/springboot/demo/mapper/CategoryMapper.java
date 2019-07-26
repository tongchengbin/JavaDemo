package com.demo.springboot.demo.mapper;


import com.demo.springboot.demo.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


//mybatis 注解方式

@Mapper
public interface CategoryMapper {

//    @Select("select * from category")
    List<Category> findAll();
}
