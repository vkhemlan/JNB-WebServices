package cl.bomberos.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cuerpos")
public class CuerpoList {
	private List<Cuerpo> cuerpos;
	
	public CuerpoList() {}
	
	public CuerpoList(List<Cuerpo> cuerpos) {
		this.cuerpos = cuerpos;
	}
	
	@XmlElement(name="cuerpo")
	public List<Cuerpo> getCuerpos() {
		return cuerpos;
	}
	
	public void setCuerpos(List<Cuerpo> cuerpos) {
		this.cuerpos = cuerpos;
	}
}
