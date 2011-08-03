package cl.bomberos.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cl.bomberos.bean.UsuarioTieneMailbox;

public class UsuarioTieneMailboxDao {
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public UsuarioTieneMailbox get(int id) {
		UsuarioTieneMailbox usuarioTieneMailbox = hibernateTemplate.get(UsuarioTieneMailbox.class, id);
		return usuarioTieneMailbox;
	}
}
