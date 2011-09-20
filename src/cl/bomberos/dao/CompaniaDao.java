package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Compania;
import cl.bomberos.bean.CompaniaList;

public class CompaniaDao {
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public CompaniaList getAll() {
		log.info("Obteniendo todas las compañías");
		Session principalSession = principalSessionFactory.openSession();
		Query allCompaniasQuery = principalSession
				.createQuery("from Compania as compania order by compania.id");

		@SuppressWarnings("rawtypes")
		List companias_raw = allCompaniasQuery.list();
		
		List<Compania> companias = new ArrayList<Compania>();
		
		for (Object raw_compania : companias_raw) {
			companias.add((Compania) raw_compania);
		}

		principalSession.close();
				
		return new CompaniaList(companias);
	}
}
