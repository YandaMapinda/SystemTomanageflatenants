package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.RentalTransfers;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface RentalTransferRepository extends IRepository<RentalTransfers, String> {
    Set<RentalTransferRepository> getAll();
}
