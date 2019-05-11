package property.tenant.manegement.service.person;

import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface TenantService extends IService<Tenant, String> {
    Set<Tenant> getAll();
}
