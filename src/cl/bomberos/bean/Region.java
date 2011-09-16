package cl.bomberos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "region")
@Entity
@Table(name = "regiones")
public class Region {
	private int id;
	private String nombre;
	private int numero;

	@Id
	@GeneratedValue
	@Column(name="regi_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="regi_nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="regi_nro", nullable=false)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
