package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface RentalTransfersService extends IService<RentalTransfers,String> {
    Set<RentalTransfers>getAll();
}
