package cl.bomberos.region.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import cl.bomberos.region.bean.Region;
import cl.bomberos.region.bean.RegionList;
import cl.bomberos.util.HibernateUtil;

public class RegionDao {
	public static final SessionFactory sessionFactory = HibernateUtil.getPrincipalSessionFactory();
	
	public static Region get(int id) {
		Session session = sessionFactory.openSession();
		Region region = (Region) session.get(Region.class, id);
		session.close();
		return region;
	}
	
	public static RegionList all() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Region> regiones = (List<Region>) session.createQuery("from Region order by id").list();
		session.close();
		return new RegionList(regiones);
	}
}
