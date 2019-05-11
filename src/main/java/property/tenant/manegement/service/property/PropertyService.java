package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PropertyService extends IService<Property, String> {
    Set<Property>getAll();
}
