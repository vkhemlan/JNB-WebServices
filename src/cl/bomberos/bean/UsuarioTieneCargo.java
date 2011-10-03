package cl.bomberos.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usu_cargo")
public class UsuarioTieneCargo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Cargo cargo;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usu", referencedColumnName = "usu_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario =usuario;
	}

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carg_nombre", referencedColumnName = "cargo_id")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
