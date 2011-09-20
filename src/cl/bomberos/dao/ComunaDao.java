package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Comuna;
import cl.bomberos.bean.ComunaList;

public class ComunaDao {
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public ComunaList getAll() {
		log.info("Obteniendo todas las comunas");
		Session principalSession = principalSessionFactory.openSession();
		Query allComunasQuery = principalSession
				.createQuery("from Comuna as comuna order by comuna.id");

		@SuppressWarnings("rawtypes")
		List comunas_raw = allComunasQuery.list();
		
		List<Comuna> comunas = new ArrayList<Comuna>();
		
		for (Object raw_comuna : comunas_raw) {
			comunas.add((Comuna) raw_comuna);
		}

		principalSession.close();
				
		return new ComunaList(comunas);
	}
}
