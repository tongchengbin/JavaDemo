import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserTest {

    public static void main(String[] args) {
        test2();
    }

    static void test2(){

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();
        User p1 = (User) s.get(User.class, 1);
        System.out.println("log1");
        User p2 = (User) s.get(User.class, 1);
        System.out.println("log2");
        s.getTransaction().commit();
        s.close();
        Session s2 = sf.openSession();
        s2.beginTransaction();
        User p3 = (User) s2.get(User.class, 1);
        System.out.println("log3");
        s2.getTransaction().commit();
        s2.close();
        sf.close();

    }



}
