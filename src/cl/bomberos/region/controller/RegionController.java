package cl.bomberos.region.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.region.bean.Region;
import cl.bomberos.region.bean.RegionList;
import cl.bomberos.region.dao.RegionDao;

@Controller
public class RegionController {
	
	public RegionController() {
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/region/{id}")
	public ModelAndView getRegion(@PathVariable String id) {
		Region region = RegionDao.get(Integer.parseInt(id));
		return new ModelAndView("region", "region", region);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/region/all")
	public ModelAndView getRegions() {
		RegionList regiones = RegionDao.all();
		return new ModelAndView("regiones", "regiones", regiones);
	}
	
}
