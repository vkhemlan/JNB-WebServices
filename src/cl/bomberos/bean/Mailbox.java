package cl.bomberos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mailbox")
@Entity
@Table(name = "mailbox")
public class Mailbox implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int idCorreo;

	@Id
	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="correopk")
	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}
}
