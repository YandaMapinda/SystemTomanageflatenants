package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface LogRentalService extends IService<Log_Rentals,String> {
    Set<Log_Rentals>getAll();
}
