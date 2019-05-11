package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Period_Rentals;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PeriodRentalService extends IService<Period_Rentals,String> {
    Set<Period_Rentals>getAll();
}
