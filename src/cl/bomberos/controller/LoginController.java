package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.Usuario;
import cl.bomberos.dao.MailboxDao;

@Controller
public class LoginController {
	private MailboxDao mailboxDao;
	private Log log;

	public LoginController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}

	public void setMailboxDao(MailboxDao mailboxDao) {
		this.mailboxDao = mailboxDao;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login/")
	public ModelAndView login(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		log.info("Accessed login");
		Usuario usuario = mailboxDao.authenticateUser(username, password);
		return new ModelAndView("usuario", "usuario", usuario);
	}
}
