package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PropertTypeRepository  extends IRepository<Property_Types, String> {
    Set<Property_Types> getAll();
}
