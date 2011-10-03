package cl.bomberos.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cargos")
public class CargoList {
	private List<Cargo> cargos;
	
	public CargoList() {}
	
	public CargoList(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	@XmlElement(name="cargo")
	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}
