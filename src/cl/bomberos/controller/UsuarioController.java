package cl.bomberos.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.bean.CargoList;
import cl.bomberos.bean.Usuario;
import cl.bomberos.dao.UsuarioDao;
import cl.bomberos.dao.UsuarioTieneCargoDao;

@Controller
public class UsuarioController {
	private UsuarioDao usuarioDao;
	private UsuarioTieneCargoDao usuarioTieneCargoDao;
	private Log log;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public void setUsuarioTieneCargoDao(UsuarioTieneCargoDao usuarioTieneCargoDao) {
		this.usuarioTieneCargoDao = usuarioTieneCargoDao;
	}


	public UsuarioController() {
	}
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuario/{idUsuario}/")
	public ModelAndView get(@PathVariable String idUsuario) {
		log.info("Solicitando información del usuario con id " + idUsuario);
		Usuario u = usuarioDao.get(Integer.parseInt(idUsuario));
		return new ModelAndView("usuario", "usuario", u);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuario/{idUsuario}/cargos/")
	public ModelAndView getCargos(@PathVariable String idUsuario) {
		log.info("Solicitando cargos del usuario con id " + idUsuario);
		Usuario usuario = usuarioDao.get(Integer.parseInt(idUsuario));
		CargoList cargoList = usuarioTieneCargoDao.getCargosUsuario(usuario);
		return new ModelAndView("usuario", "usuario", cargoList);
	}
}
