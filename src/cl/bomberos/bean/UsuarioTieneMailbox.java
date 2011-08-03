package cl.bomberos.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mail_usu")
public class UsuarioTieneMailbox implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private Mailbox mailbox;

	@Id
	@Column(name="fk_usu")
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_mail", referencedColumnName = "correopk")
	public Mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}

}
