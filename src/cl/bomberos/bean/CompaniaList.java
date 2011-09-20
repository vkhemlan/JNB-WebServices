package cl.bomberos.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="companias")
public class CompaniaList {
	private List<Compania> companias;
	
	public CompaniaList() {}
	
	public CompaniaList(List<Compania> companias) {
		this.companias = companias;
	}
	
	@XmlElement(name="compania")
	public List<Compania> getCompanias() {
		return companias;
	}
	
	public void setCompanias(List<Compania> companias) {
		this.companias = companias;
	}
}
