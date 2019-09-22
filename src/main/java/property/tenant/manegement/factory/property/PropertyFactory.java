package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.util.Misc;

public class PropertyFactory {
    public static Property getProperty(String address, String name){
        return new Property.Builder().property_id(Misc.generateId()).address(address).name(name).build();
    }
}
