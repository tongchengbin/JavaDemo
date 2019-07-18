import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class User2Test {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        User p1 = (User) s.get(User.class, 1);
        System.out.println(p1.getId());
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
