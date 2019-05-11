package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface LeaseService extends IService<Lease, String> {
    Set<Lease>getAll();
}

