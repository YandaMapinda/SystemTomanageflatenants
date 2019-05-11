package property.tenant.manegement.service.accounts.impl;

import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.repository.accounting.report.TenantStatementRepository;
import property.tenant.manegement.repository.accounting.report.impl.TenantStatementRepositoryImpl;
import property.tenant.manegement.service.accounts.TenantStatementService;

import java.util.Set;

public class TenantStatementServiceImpl implements TenantStatementService {

    private static TenantStatementServiceImpl service = null;
    private TenantStatementRepository repository;

    private TenantStatementServiceImpl() {
        this.repository = TenantStatementRepositoryImpl.getInstance();
    }

    public static TenantStatementServiceImpl getService(){
        if (service == null) service = new TenantStatementServiceImpl();
        return service;
    }

    @Override
    public Set<Tenant_statement> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Tenant_statement create(Tenant_statement tenant_statement) {
        return this.repository.create(tenant_statement);
    }

    @Override
    public Tenant_statement update(Tenant_statement tenant_statement) {
        return this.repository.update(tenant_statement);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Tenant_statement read(String s) {
        return this.repository.read(s);
    }
}
