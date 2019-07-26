package com.demo.springboot.demo.dao;

import com.demo.springboot.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CategoryDAO extends JpaRepository<Category,Integer> {



}