package com.demo.test;
 
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.CategoryDAO;
import com.demo.pojo.Category;
 
 
public class TestSpring {
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        CategoryDAO dao = (CategoryDAO) context.getBean("dao");
        Category c = new Category();
        c.setName("category yyy");

        dao.save(c);

        Category c2 = dao.get(Category.class, 1);

        c2.setName("category zzz");
        dao.update(c2);

        dao.delete(c2);
        
        

    }
}