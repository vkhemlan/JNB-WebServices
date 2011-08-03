package cl.bomberos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Mailbox;
import cl.bomberos.bean.Usuario;
import cl.bomberos.bean.UsuarioTieneMailbox;

public class MailboxDao {
	private SessionFactory postfixSessionFactory;
	private SessionFactory principalSessionFactory;
	
	public void setPostfixSessionFactory(SessionFactory postfixSessionFactory) {
		this.postfixSessionFactory = postfixSessionFactory;
	}
	
	public void setPrincipalSessionFactory(SessionFactory principalSessionFactory) {
		this.principalSessionFactory = principalSessionFactory;
	}

	public Usuario authenticateUser(String username, String password) {
		Session postfixSession = postfixSessionFactory.openSession();
		
		Query passwordCheckQuery = postfixSession.createQuery("from Mailbox where username = :username and password = :password");
		passwordCheckQuery.setParameter("username", username);
		passwordCheckQuery.setParameter("password", password);
		@SuppressWarnings("rawtypes")
		List mailboxes = passwordCheckQuery.list();
		if (mailboxes.isEmpty()) {
			postfixSession.close();
			return null;
		}
		
		Mailbox mailbox = (Mailbox) mailboxes.get(0);
		
		Query mailboxCheckQuery = postfixSession.createQuery("from UsuarioTieneMailbox where mailbox = :mailbox");
		mailboxCheckQuery.setParameter("mailbox", mailbox);
		@SuppressWarnings("rawtypes")
		List mailboxAssocciations = mailboxCheckQuery.list();
		
		postfixSession.close();
		
		if (mailboxAssocciations.isEmpty()) {
			return null;
		}
		
		UsuarioTieneMailbox mailboxAssociation = (UsuarioTieneMailbox) mailboxAssocciations.get(0);
		
		Session principalSession = principalSessionFactory.openSession();
		Query usuarioCheckQuery = principalSession.createQuery("from Usuario where id = :id");
		usuarioCheckQuery.setParameter("id", mailboxAssociation.getIdUsuario());
		
		@SuppressWarnings("rawtypes")
		List usuarios = usuarioCheckQuery.list();
		
		principalSession.close();

		if (usuarios.isEmpty()) {
			return null;
		}
		
		Usuario usuario = (Usuario) usuarios.get(0);
		
		return usuario;
	}
}
