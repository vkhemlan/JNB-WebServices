package cl.bomberos.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="comunas")
public class ComunaList {
	private List<Comuna> comunas;
	
	public ComunaList() {}
	
	public ComunaList(List<Comuna> comunas) {
		this.comunas = comunas;
	}
	
	@XmlElement(name="comuna")
	public List<Comuna> getComunas() {
		return comunas;
	}
	
	public void setComunas(List<Comuna> comunas) {
		this.comunas = comunas;
	}
}
