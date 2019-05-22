package property.tenant.manegement.factory.property;

import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.util.Misc;

public class PropertyRooms_TypeFactory {
    public static PropertyRooms_Type getPropertyRooms_Type(String unit_type_name){
        return new PropertyRooms_Type.Builder().unit_type_id(Misc.generateId()).unit_type_name(unit_type_name).build();
    }
}
