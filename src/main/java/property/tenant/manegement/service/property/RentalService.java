package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface RentalService extends IService<Rental,String> {
    Set<Rental>getAll();
}
