package cl.bomberos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cl.bomberos.bean.Cargo;
import cl.bomberos.bean.CargoList;
import cl.bomberos.bean.Usuario;
import cl.bomberos.bean.UsuarioTieneCargo;

public class UsuarioTieneCargoDao {
	private SessionFactory sessionFactory;;
	private Log log;
	
	public void setLog(Log log) {
		this.log = log;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public CargoList getCargosUsuario(Usuario usuario) {
		log.info("Obteniendo cargos del usuario " + usuario);
		Session principalSession = sessionFactory.openSession();
		
		Query queryCargosUsuario = principalSession.createQuery("from UsuarioTieneCargo where usuario = :usuario");
		queryCargosUsuario.setParameter("usuario", usuario);

		@SuppressWarnings("rawtypes")
		List usuarioTieneCargos = queryCargosUsuario.list();
		
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		
		for (Object o : usuarioTieneCargos) {
			UsuarioTieneCargo utc = (UsuarioTieneCargo) o;
			cargos.add(utc.getCargo());
		}
		
		return new CargoList(cargos);
	}
}
