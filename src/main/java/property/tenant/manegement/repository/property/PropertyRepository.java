package property.tenant.manegement.repository.property;


import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PropertyRepository extends IRepository<Property, String> {
    Property retrieveByDesc(String addDesc);
    Set<Property> getAll();
}
