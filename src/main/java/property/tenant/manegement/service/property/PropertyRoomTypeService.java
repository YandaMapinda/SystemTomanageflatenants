package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PropertyRoomTypeService extends IService <PropertyRooms_Type, String> {
    Set<PropertyRooms_Type> getAll();
}
