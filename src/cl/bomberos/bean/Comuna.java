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

import cl.bomberos.adapter.ProvinciaAdapter;

@XmlRootElement(name = "comuna")
@Entity
@Table(name = "comuna")
public class Comuna implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Provincia provincia;

	@Id
	@GeneratedValue
	@Column(name="comu_ide")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="comu_nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prov_id", referencedColumnName = "prov_id")
	@XmlJavaTypeAdapter(value = ProvinciaAdapter.class)
	public Provincia getProvincia() {
		return provincia;
	}
	
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
