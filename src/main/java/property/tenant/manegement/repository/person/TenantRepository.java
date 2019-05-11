package property.tenant.manegement.repository.person;

import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface TenantRepository extends IRepository<Tenant,String> {
    Set<Tenant> getAll();
}
