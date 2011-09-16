package cl.bomberos.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="provincias")
public class ProvinciaList {
	private List<Provincia> provincias;
	
	public ProvinciaList() {}
	
	public ProvinciaList(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	@XmlElement(name="provincia")
	public List<Provincia> getProvincias() {
		return provincias;
	}
	
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
}
