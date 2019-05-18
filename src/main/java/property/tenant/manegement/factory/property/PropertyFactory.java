package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.util.Misc;

public class PropertyFactory {
    public static Property getProperty(String address, String name, double amount){
        return new Property.Builder().property_id(Misc.generateId()).address(address).name(name).amount(amount).build();
    }
}
