package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LogRentalRepository extends IRepository<Log_Rentals,String> {
    Set<LogRentalRepository>getAll();
}
