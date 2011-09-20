package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.ComunaList;
import cl.bomberos.dao.ComunaDao;

@Controller
public class ComunaController {
	private ComunaDao comunaDao;
	private Log log;
	
	public void setComunaDao(ComunaDao comunaDao) {
		this.comunaDao = comunaDao;
	}


	public ComunaController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/comuna/")
	public ModelAndView all() {
		log.info("Solicitado listado de comunas");
		ComunaList comunas = comunaDao.getAll();
		return new ModelAndView("usuario", "usuario", comunas);
	}
}
