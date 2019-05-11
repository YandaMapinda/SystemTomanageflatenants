package property.tenant.manegement.service.property;

import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface LeaseTransferService extends IService<Lease_Transfer,String> {
    Set<Lease_Transfer>getAll();
}
