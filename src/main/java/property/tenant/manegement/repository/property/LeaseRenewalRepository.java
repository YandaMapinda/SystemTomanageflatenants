package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LeaseRenewalRepository extends IRepository<Lease_Renewal, String> {
    Set<Lease_Renewal> getAll();
}
