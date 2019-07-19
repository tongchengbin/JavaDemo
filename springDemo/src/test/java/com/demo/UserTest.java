package test.java.com.demo;

import com.demo.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        User p = (User) context.getBean("u");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());
    }
}
