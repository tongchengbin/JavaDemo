package com.demo.springboot.demo.Controller;

import com.demo.springboot.demo.dao.CategoryDAO;
import com.demo.springboot.demo.mapper.CategoryMapper;
import com.demo.springboot.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;


    /**
     *
     */
    @Autowired CategoryMapper categoryMapper;

    @ResponseBody
    @RequestMapping("/categorylist")
    public List<Category> list(){
        List<Category> cs=categoryDAO.findAll();
        System.out.println(cs);
        return cs;

    }

    @ResponseBody
    @RequestMapping("/categorylistmapper")
    public List<Category> listmapper(){
        List<Category> cs= categoryMapper.findAll();
        return cs;
    }
}
