package cl.bomberos.usuario.dao;

import org.hibernate.SessionFactory;

import cl.bomberos.usuario.bean.Usuario;

public interface UsuarioDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract Usuario get(int id);

}