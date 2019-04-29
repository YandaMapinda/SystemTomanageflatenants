package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Rental;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface RentalRepository extends IRepository<Rental,String> {
        Set<RentalRepository>getAll();
}
