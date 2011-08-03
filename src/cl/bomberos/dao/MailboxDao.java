package cl.bomberos.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.bomberos.bean.Mailbox;

public class MailboxDao {
	private SessionFactory postfixSessionFactory;
	private Log log;
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	public void setPostfixSessionFactory(SessionFactory postfixSessionFactory) {
		this.postfixSessionFactory = postfixSessionFactory;
	}
	
	public Mailbox getAuthenticatedUserMailbox(String username, String password) {
		log.info("Obteniendo mailbox para cliente con nombre de usuario '" + username + "' y contraseña '" + password +"'");
		Session postfixSession = postfixSessionFactory.openSession();
		
		Query passwordCheckQuery = postfixSession.createQuery("from Mailbox where username = :username and password = :password");
		passwordCheckQuery.setParameter("username", username);
		passwordCheckQuery.setParameter("password", password);
		@SuppressWarnings("rawtypes")
		List mailboxes = passwordCheckQuery.list();
		if (mailboxes.isEmpty()) {
			log.info("No se encontró mailbox para el usuario, usualmente esto significa que el nombre de usuario y contraseña no concuerdan");
			postfixSession.close();
			return null;
		}
		
		Mailbox mailbox = (Mailbox) mailboxes.get(0);
		
		log.info("Mailbox encontrado con username " + mailbox.getUsername());
		return mailbox;
	}
}
