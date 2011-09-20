package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Cuerpo;
import cl.bomberos.bean.CuerpoList;

public class CuerpoDao {
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public CuerpoList getAll() {
		log.info("Obteniendo todos los cuerpos");
		Session principalSession = principalSessionFactory.openSession();
		Query allCuerposQuery = principalSession
				.createQuery("from Cuerpo as cuerpo order by cuerpo.id");

		@SuppressWarnings("rawtypes")
		List cuerpos_raw = allCuerposQuery.list();
		
		List<Cuerpo> comunas = new ArrayList<Cuerpo>();
		
		for (Object raw_cuerpo : cuerpos_raw) {
			comunas.add((Cuerpo) raw_cuerpo);
		}

		principalSession.close();
				
		return new CuerpoList(comunas);
	}
}
