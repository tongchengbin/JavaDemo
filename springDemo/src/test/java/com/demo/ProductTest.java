package test.java.com.demo;

import com.demo.pojo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

        Product p = (Product) context.getBean("p");

        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());
    }
}
