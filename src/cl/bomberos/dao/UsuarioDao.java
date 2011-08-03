package cl.bomberos.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cl.bomberos.bean.Usuario;

public class UsuarioDao {
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public Usuario get(int id) {
		Usuario usuario = hibernateTemplate.get(Usuario.class, id);
		return usuario;
	}
}
