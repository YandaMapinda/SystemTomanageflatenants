package property.tenant.manegement.repository.accounting.report.impl;


import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.repository.accounting.report.TenantStatementRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TenantStatementRepositoryImpl implements TenantStatementRepository {
    private static TenantStatementRepositoryImpl repository = null;

    private Map<String, Tenant_statement> tenantStatementMap;

    private TenantStatementRepositoryImpl() {
        tenantStatementMap = new HashMap<String, Tenant_statement>();
    }

    public static TenantStatementRepositoryImpl  getInstance(){
        if(repository == null) repository = new TenantStatementRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Tenant_statement> getAll() {
        return null;
    }

    @Override
    public Tenant_statement create(Tenant_statement tenant_statement) {
        tenantStatementMap.put(tenant_statement.getId(),tenant_statement);
        Tenant_statement savedA = tenantStatementMap.get(tenant_statement.getId());
        return savedA;
    }

    @Override
    public Tenant_statement update(Tenant_statement tenant_statement) {
        tenantStatementMap.put(tenant_statement.getId(),tenant_statement);
        Tenant_statement savedA = tenantStatementMap.get(tenant_statement.getId());
        return savedA;
    }

    @Override
    public void delete(String s) {
        tenantStatementMap.remove(s);
    }

    @Override
    public Tenant_statement read(String s) {
        Tenant_statement statement = tenantStatementMap.get(s);
        return statement;
    }
}
