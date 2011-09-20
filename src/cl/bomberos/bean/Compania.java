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

import cl.bomberos.adapter.CuerpoAdapter;

@XmlRootElement(name = "compania")
@Entity
@Table(name = "companias")
public class Compania implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int numero;
	private Cuerpo cuerpo;

	@Id
	@GeneratedValue
	@Column(name="comp_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="comp_nro", nullable=false)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_fk_cuerpo", referencedColumnName = "cuer_id")
	@XmlJavaTypeAdapter(value = CuerpoAdapter.class)
	public Cuerpo getCuerpo() {
		return cuerpo;
	}
	
	public void setCuerpo(Cuerpo cuerpo) {
		this.cuerpo = cuerpo;
	}
}
