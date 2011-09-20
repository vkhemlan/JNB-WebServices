package cl.bomberos.reference;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegionReference 
{ 
    @XmlAttribute
    public int id;
}
