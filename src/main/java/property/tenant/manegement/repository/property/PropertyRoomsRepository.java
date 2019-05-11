package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.PropertyRooms;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PropertyRoomsRepository extends IRepository<PropertyRooms, String> {
    Set<PropertyRooms> getAll();
}
