package property.tenant.manegement.repository.person.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.repository.person.TenantRepository;

import java.util.*;
@Repository("InTenantMemory")
public class TenantRepositoryImpl implements TenantRepository {

    private static TenantRepositoryImpl repository = null;

    private Map<String,Tenant> tenantMap;

    private TenantRepositoryImpl() {
        tenantMap = new HashMap<String, Tenant>();
    }

    public static TenantRepositoryImpl getInstance(){
        if(repository == null) repository = new TenantRepositoryImpl();
        return repository;
    }


    public Tenant create(Tenant t) {
        tenantMap.put(t.getTenantId(),t);
        Tenant savedT = tenantMap.get(t.getTenantId());
        return savedT;
    }

    @Override
    public Tenant update(Tenant tenant) {
        tenantMap.put(tenant.getTenantId(),tenant);
        Tenant savedT = tenantMap.get(tenant.getTenantId());
        return savedT;
    }

    @Override
    public void delete(String s) {
        tenantMap.remove(s);
    }

    @Override
    public Tenant read(String s) {
        Tenant tenant= tenantMap.get(s);
        return tenant;
    }

    @Override
    public Set<Tenant> getAll(){
        Collection<Tenant> tenants = this.tenantMap.values();
        Set<Tenant> set = new HashSet<>();
        set.addAll(tenants);
        return set;
    }



}
