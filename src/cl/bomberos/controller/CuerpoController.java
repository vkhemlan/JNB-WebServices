package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.CuerpoList;
import cl.bomberos.dao.CuerpoDao;

@Controller
public class CuerpoController {
	private CuerpoDao cuerpoDao;
	private Log log;
	
	public void setCuerpoDao(CuerpoDao cuerpoDao) {
		this.cuerpoDao = cuerpoDao;
	}


	public CuerpoController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cuerpo/")
	public ModelAndView all() {
		log.info("Solicitado listado de cuerpos");
		CuerpoList cuerpos = cuerpoDao.getAll();
		return new ModelAndView("usuario", "usuario", cuerpos);
	}
}
