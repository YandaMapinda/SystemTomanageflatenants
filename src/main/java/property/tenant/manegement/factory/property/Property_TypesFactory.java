package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.util.Misc;

public class Property_TypesFactory {
    public static Property_Types getProperty_Types(String property_type_name){
        return new Property_Types.Builder().property_type_id(Misc.generateId()).property_type_name(property_type_name).build();
    }
}
