package cl.bomberos.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory principalSessionFactory;
	
	static {
		try {
			principalSessionFactory = new Configuration().configure("principal.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Falló la creación del SessionFactory 'principal' " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getPrincipalSessionFactory() {
		return principalSessionFactory;
	}
}
