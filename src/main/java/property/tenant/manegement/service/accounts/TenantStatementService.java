package property.tenant.manegement.service.accounts;

import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface TenantStatementService extends IService<Tenant_statement,String> {
    Set<Tenant_statement> getAll();
}
