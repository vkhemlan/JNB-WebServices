package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.ProvinciaList;
import cl.bomberos.dao.ProvinciaDao;

@Controller
public class ProvinciaController {
	private ProvinciaDao provinciaDao;
	private Log log;
	
	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}


	public ProvinciaController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/provincia/")
	public ModelAndView all() {
		log.info("Solicitado listado de provincias");
		ProvinciaList provincias = provinciaDao.getAll();
		return new ModelAndView("usuario", "usuario", provincias);
	}
}
