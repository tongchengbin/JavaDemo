import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestHibernate {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		User p = new User();
		p.setName("iphone7");
		p.setAge(7);
		p.setSex("man");
		s.save(p);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}