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

import cl.bomberos.adapter.RegionAdapter;

@XmlRootElement(name = "provincia")
@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Region region;

	@Id
	@GeneratedValue
	@Column(name="prov_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="prov_nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prov_fk_region", referencedColumnName = "regi_id")
	@XmlJavaTypeAdapter(value = RegionAdapter.class)
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
}
