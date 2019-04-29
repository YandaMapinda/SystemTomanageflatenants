package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LeaseRepository extends IRepository<Lease, String> {
    Set<LeaseRepository>getAll();
}
