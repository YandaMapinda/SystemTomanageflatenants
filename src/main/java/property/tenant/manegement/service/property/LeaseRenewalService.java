package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface LeaseRenewalService extends IService<Lease_Renewal, String> {
    Set<Lease_Renewal>getAll();
}
