package cl.bomberos.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Mailbox;
import cl.bomberos.bean.Usuario;
import cl.bomberos.bean.UsuarioTieneMailbox;

public class UsuarioDao {
	private SessionFactory postfixSessionFactory;
	private SessionFactory principalSessionFactory;
	private Log log;

	public void setLog(Log log) {
		this.log = log;
	}

	public void setPostfixSessionFactory(SessionFactory postfixSessionFactory) {
		this.postfixSessionFactory = postfixSessionFactory;
	}

	public void setPrincipalSessionFactory(
			SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}
	
	public Usuario get(int id) {
		log.info("Obteniendo usuario con id " + id);
		Session principalSession = principalSessionFactory.openSession();
		Query usuarioCheckQuery = principalSession
				.createQuery("from Usuario where id = :id");
		usuarioCheckQuery.setParameter("id", id);

		@SuppressWarnings("rawtypes")
		List usuarios = usuarioCheckQuery.list();

		principalSession.close();

		if (usuarios.isEmpty()) {
			log.info("No se encontró usuario con ese id");
			return null;
		}
		
		Usuario usuario = (Usuario) usuarios.get(0);
		
		log.info("Usuario encontrado: " + usuario.fullName());
		
		return usuario;
	}

	public Usuario getUsuarioWithMailbox(Mailbox userMailbox) {
		log.info("Obteniendo usuario para mailbox con nombre de usuario " + userMailbox.getUsername());
		Session postfixSession = postfixSessionFactory.openSession();

		log.info("Buscando asociaciones en mail_usu para el mailbox con correopk " + userMailbox.getIdCorreo());
		Query mailboxCheckQuery = postfixSession
				.createQuery("from UsuarioTieneMailbox where mailbox = :mailbox");
		mailboxCheckQuery.setParameter("mailbox", userMailbox);
		@SuppressWarnings("rawtypes")
		List mailboxAssociations = mailboxCheckQuery.list();

		postfixSession.close();

		if (mailboxAssociations.isEmpty()) {
			log.info("No hay asociaciones en 'mail_usu' para este usuario con correopk de " + userMailbox.getIdCorreo());
			return null;
		} else if (mailboxAssociations.size() > 1) {
			log.info("Existen múltiples asociaciones en 'mail_usu' para este usuario con correopk de " + userMailbox.getIdCorreo() + ", usando la primera");
		} else {
			log.info("Asociación única encontrada");
		}

		UsuarioTieneMailbox mailboxAssociation = (UsuarioTieneMailbox) mailboxAssociations.get(0);
		
		log.info("Usando asociación con id de usuario " + mailboxAssociation.getIdUsuario());

		Usuario usuario = this.get(mailboxAssociation.getIdUsuario());
		
		return usuario;
	}
}
