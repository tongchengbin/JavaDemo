package test.java.com.demo;

import com.demo.pojo.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CategoryTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

        Category c = (Category) context.getBean("c");

        System.out.println(c.getName());
        c.setName("new name");
        Category c2 = (Category) context.getBean("c");
        System.out.println(c2.getName());
    }
}