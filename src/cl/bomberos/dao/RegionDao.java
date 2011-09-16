package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Region;
import cl.bomberos.bean.RegionList;

public class RegionDao {
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public RegionList getAll() {
		log.info("Obteniendo todas las regiones");
		Session principalSession = principalSessionFactory.openSession();
		Query allRegionsQuery = principalSession
				.createQuery("from Region as region order by region.numero");

		@SuppressWarnings("rawtypes")
		List regiones_raw = allRegionsQuery.list();
		
		List<Region> regiones = new ArrayList<Region>();
		
		for (Object raw_region : regiones_raw) {
			regiones.add((Region) raw_region);
		}

		principalSession.close();
				
		return new RegionList(regiones);
	}
}
