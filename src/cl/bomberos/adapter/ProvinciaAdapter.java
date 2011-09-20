package cl.bomberos.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cl.bomberos.bean.Provincia;
import cl.bomberos.reference.ProvinciaReference;

public class ProvinciaAdapter extends XmlAdapter<ProvinciaReference, Provincia>
{
    @Override
    public ProvinciaReference marshal(Provincia v) throws Exception 
    {   
    	ProvinciaReference ref = new ProvinciaReference();
        ref.id = v.getId();
        return ref;
    }

    @Override
    public Provincia unmarshal(ProvinciaReference v) throws Exception 
    {
        return null;
    }
}
