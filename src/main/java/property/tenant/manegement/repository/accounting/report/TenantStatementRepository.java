package property.tenant.manegement.repository.accounting.report;

import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface TenantStatementRepository extends IRepository<Tenant_statement,String> {
    Set<TenantStatementRepository>getAll();
}
