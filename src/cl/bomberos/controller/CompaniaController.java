package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.CompaniaList;
import cl.bomberos.dao.CompaniaDao;

@Controller
public class CompaniaController {
	private CompaniaDao companiaDao;
	private Log log;
	
	public void setCompaniaDao(CompaniaDao companiaDao) {
		this.companiaDao = companiaDao;
	}


	public CompaniaController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/compania/")
	public ModelAndView all() {
		log.info("Solicitado listado de compañías");
		CompaniaList companias = companiaDao.getAll();
		return new ModelAndView("usuario", "usuario", companias);
	}
}
