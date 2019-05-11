package property.tenant.manegement.repository.property;

import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface LeasePaymentRepository extends IRepository<Lease_Payments, String> {
    Set<Lease_Payments> getAll();
}
