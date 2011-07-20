package cl.bomberos.region.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="regiones")
public class RegionList {
	private List<Region> regiones;
	
	public RegionList() {}
	
	public RegionList(List<Region> regiones) {
		this.regiones = regiones;
	}
	
	@XmlElement(name="region")
	public List<Region> getRegiones() {
		return regiones;
	}
	
	public void setRegiones(List<Region> regiones) {
		this.regiones = regiones;
	}
}
