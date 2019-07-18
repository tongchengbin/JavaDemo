import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserTest {

    public static void main(String[] args) {
        test3();
    }

    static void test2(){

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        Session s3=sf.openSession();
        System.out.println(s==s3);
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


//    乐观锁

    /**
     *  每次获取数据的时候，都不会担心数据被修改，所以每次获取数据的时候都不会进行加锁，
     *  但是在更新数据的时候需要判断该数据是否被别人修改过。如果数据被其他线程修改，则不进行数据更新，
     *  如果数据没有被其他线程修改，则进行数据更新。由于数据没有进行加锁，
     *  期间该数据可以被其他线程进行读写操作。一般使用version方式和CAS操作方式
     */

    static void test3(){
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session s1 = sf.openSession();
            Session s2 = sf.openSession();

            s1.beginTransaction();
            s2.beginTransaction();

            User p1 = (User) s1.get(User.class, 1);
            System.out.println("AGE: " + p1.getAge());

            p1.setAge(p1.getAge() + 5);

            User p2 = (User) s2.get(User.class, 1);
            p2.setAge(p2.getAge() + 1000);

            s1.update(p1);
            s2.update(p2);

            s1.getTransaction().commit();
            s2.getTransaction().commit();

            User p = (User) s1.get(User.class, 1);

            System.out.println("经过两次价格增加后，AGE变为: " + p.getAge());

            s1.close();
            s2.close();

            sf.close();
        }
//        Exception in thread "main" org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect)



}
