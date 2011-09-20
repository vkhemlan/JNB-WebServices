package cl.bomberos.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cl.bomberos.bean.Region;
import cl.bomberos.reference.RegionReference;

public class RegionAdapter extends XmlAdapter<RegionReference, Region>
{
    @Override
    public RegionReference marshal(Region v) throws Exception 
    {   
    	RegionReference ref = new RegionReference();
        ref.id = v.getId();
        return ref;
    }

    @Override
    public Region unmarshal(RegionReference v) throws Exception 
    {
        return null;
    }
}
