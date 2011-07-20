package cl.bomberos.region.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.region.bean.Region;
import cl.bomberos.region.dao.RegionDao;
import cl.bomberos.util.HibernateUtil;

@Controller
public class RegionController {
	private SessionFactory sessionFactory;
	
	public RegionController() {
		sessionFactory = HibernateUtil.getPrincipalSessionFactory();
	}
	
	private static final String XML_VIEW_NAME = "employees";
	
	@RequestMapping(method=RequestMethod.GET, value="/region/{id}")
	public ModelAndView getRegion(@PathVariable String id) {
		Region region = RegionDao.get(Integer.parseInt(id));
		return new ModelAndView(XML_VIEW_NAME, "object", region);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/region/all")
	public ModelAndView getRegions() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			List regiones = session.createQuery("from Region").list();
			transaction.commit();
			return new ModelAndView(XML_VIEW_NAME, "employees", regiones);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
}
