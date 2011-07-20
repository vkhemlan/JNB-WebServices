package cl.bomberos.usuario.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cl.bomberos.usuario.bean.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public Usuario get(int id) {
		Usuario usuario = hibernateTemplate.get(Usuario.class, id);
		return usuario;
	}
}
