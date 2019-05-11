package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PropertyRoomTypeRepository extends IRepository<PropertyRooms_Type, String> {
    Set<PropertyRooms_Type> getAll();
}
