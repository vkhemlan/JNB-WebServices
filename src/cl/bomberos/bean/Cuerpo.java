package cl.bomberos.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cl.bomberos.adapter.ComunaAdapter;

@XmlRootElement(name = "cuerpo")
@Entity
@Table(name = "cuerpos")
public class Cuerpo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Comuna comuna;

	@Id
	@GeneratedValue
	@Column(name="cuer_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="cuer_nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cuer_comuna", referencedColumnName = "comu_nombre")
	@XmlJavaTypeAdapter(value = ComunaAdapter.class)
	public Comuna getComuna() {
		return comuna;
	}
	
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
}
