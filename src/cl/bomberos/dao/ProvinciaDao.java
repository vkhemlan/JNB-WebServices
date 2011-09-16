package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Provincia;
import cl.bomberos.bean.ProvinciaList;

public class ProvinciaDao {
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public ProvinciaList getAll() {
		log.info("Obteniendo todas las regiones");
		Session principalSession = principalSessionFactory.openSession();
		Query allProvinciasQuery = principalSession
				.createQuery("from Provincia as provincia order by provincia.id");

		@SuppressWarnings("rawtypes")
		List provincias_raw = allProvinciasQuery.list();
		
		List<Provincia> provincias = new ArrayList<Provincia>();
		
		for (Object raw_provincia : provincias_raw) {
			provincias.add((Provincia) raw_provincia);
		}

		principalSession.close();
				
		return new ProvinciaList(provincias);
	}
}
