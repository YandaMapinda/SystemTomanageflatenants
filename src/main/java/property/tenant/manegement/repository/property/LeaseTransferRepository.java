package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LeaseTransferRepository extends IRepository<Lease_Transfer,String> {
    Set<LeaseTransferRepository>getAll();
}
