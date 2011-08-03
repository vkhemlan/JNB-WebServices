package cl.bomberos.controller;


import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.Mailbox;
import cl.bomberos.bean.Usuario;
import cl.bomberos.dao.MailboxDao;
import cl.bomberos.dao.UsuarioDao;

@Controller
public class LoginController {
	private MailboxDao mailboxDao;
	private UsuarioDao usuarioDao;
	private Log log;

	public LoginController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}

	public void setMailboxDao(MailboxDao mailboxDao) {
		this.mailboxDao = mailboxDao;
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login/")
	public ModelAndView login(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		log.info("Accesado sistema de login");
		Mailbox userMailbox = mailboxDao.getAuthenticatedUserMailbox(username, password);
		
		if (userMailbox == null) {
			log.info("Nombre de usuario y contraseña no calzan con ningun cliente");
			return new ModelAndView("usuario", "usuario", new Usuario());
		}
		
		Usuario usuario = usuarioDao.getUsuarioWithMailbox(userMailbox);
		if (usuario == null) {
			usuario = new Usuario();
		}
		
		return new ModelAndView("usuario", "usuario", usuario);
	}
}
