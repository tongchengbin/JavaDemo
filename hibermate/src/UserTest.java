import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserTest {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        User p = (User)s.load(User.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2");
        System.out.println(p.getId());

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
