package cl.bomberos.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cl.bomberos.bean.Cuerpo;
import cl.bomberos.reference.CuerpoReference;

public class CuerpoAdapter extends XmlAdapter<CuerpoReference, Cuerpo>
{
    @Override
    public CuerpoReference marshal(Cuerpo v) throws Exception 
    {   
    	CuerpoReference ref = new CuerpoReference();
    	if (v == null) {
    		ref.id = 0;
    	} else {
    		ref.id = v.getId();    		
    	}
        return ref;
    }

    @Override
    public Cuerpo unmarshal(CuerpoReference v) throws Exception 
    {
        return null;
    }
}
