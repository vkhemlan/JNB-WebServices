package cl.bomberos.usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.bomberos.usuario.bean.Usuario;
import cl.bomberos.usuario.dao.UsuarioDao;

@Controller
public class UsuarioController {
	private UsuarioDao usuarioDao;
	
	public UsuarioController() {
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/usuario/{id}")
	public ModelAndView getUsuario(@PathVariable String id) {
		Usuario usuario = usuarioDao.get(Integer.parseInt(id));
		return new ModelAndView("usuario", "usuario", usuario);
	}
}
