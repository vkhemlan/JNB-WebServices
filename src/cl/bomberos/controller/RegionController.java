package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.RegionList;
import cl.bomberos.dao.RegionDao;

@Controller
public class RegionController {
	private RegionDao regionDao;
	private Log log;
	
	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}


	public RegionController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/region/")
	public ModelAndView all() {
		log.info("Solicitado listado de regiones");
		RegionList regiones = regionDao.getAll();
		return new ModelAndView("usuario", "usuario", regiones);
	}
}
