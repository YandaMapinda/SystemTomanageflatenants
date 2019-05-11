package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.PropertyRooms;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PropertyRoomsService extends IService <PropertyRooms, String> {
    Set<PropertyRooms> getAll();

}
