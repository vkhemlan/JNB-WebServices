package cl.bomberos.region.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import cl.bomberos.region.bean.Region;
import cl.bomberos.util.HibernateUtil;

public class RegionDao {
	public static final SessionFactory sessionFactory = HibernateUtil.getPrincipalSessionFactory();
	
	public static Region get(int id) {
		Session session = sessionFactory.openSession();
		Region region = (Region) session.get(Region.class, id);
		session.close();
		return region;
	}
}
