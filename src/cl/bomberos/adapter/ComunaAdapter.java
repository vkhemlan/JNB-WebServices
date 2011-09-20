package cl.bomberos.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cl.bomberos.bean.Comuna;
import cl.bomberos.reference.ComunaReference;

public class ComunaAdapter extends XmlAdapter<ComunaReference, Comuna>
{
    @Override
    public ComunaReference marshal(Comuna v) throws Exception 
    {   
    	ComunaReference ref = new ComunaReference();
        ref.id = v.getId();
        return ref;
    }

    @Override
    public Comuna unmarshal(ComunaReference v) throws Exception 
    {
        return null;
    }
}
