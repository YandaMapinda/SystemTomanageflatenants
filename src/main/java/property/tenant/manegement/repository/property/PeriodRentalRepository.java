package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PeriodRentalRepository extends IRepository<Period_Rentals,String> {
    Set<PeriodRentalRepository>getAll();
}
