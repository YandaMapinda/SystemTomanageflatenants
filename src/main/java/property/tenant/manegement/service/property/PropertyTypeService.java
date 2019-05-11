package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PropertyTypeService extends IService<Property_Types, String> {
    Set<Property_Types> getAll();

}
