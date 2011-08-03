package cl.bomberos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
@Entity
@Table(name = "usuarios")
public class Usuario {
	private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String rut;
	private String digitoVerificador;
	private String direccion;
	private String telefono;
	private String telefonoCelular;
	private String ocupacion;
	private String telefonoLaboral;
	private String direccionLaboral;
	private String genero;

	@Id
	@GeneratedValue
	@Column(name="usu_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="usu_nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="usu_ape_pat", nullable=false)
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellido_paterno) {
		this.apellidoPaterno = apellido_paterno;
	}

	@Column(name="usu_ape_mat", nullable=false)
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellido_materno) {
		this.apellidoMaterno = apellido_materno;
	}

	@Column(name="usu_rut")
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name="usu_dv")
	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digito_verificador) {
		this.digitoVerificador = digito_verificador;
	}

	@Column(name="usu_direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name="usu_telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="usu_celular")
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String celular) {
		this.telefonoCelular = celular;
	}

	@Column(name="usu_ocupacion")
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	@Column(name="usu_fono_laboral")
	public String getTelefonoLaboral() {
		return telefonoLaboral;
	}

	public void setTelefonoLaboral(String telefono_laboral) {
		this.telefonoLaboral = telefono_laboral;
	}

	@Column(name="usu_direc_laboral")
	public String getDireccionLaboral() {
		return direccionLaboral;
	}

	public void setDireccionLaboral(String direccion_laboral) {
		this.direccionLaboral = direccion_laboral;
	}

	@Column(name="usu_fk_sexo")
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
