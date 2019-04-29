package property.tenant.manegement.repository.impl.person;

import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.repository.person.TenantRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        tenantMap.put(t.getId(),t);
        Tenant savedT = tenantMap.get(t.getId());
        return savedT;
    }

    @Override
    public Tenant update(Tenant tenant) {
        tenantMap.put(tenant.getId(),tenant);
        Tenant savedT = tenantMap.get(tenant.getId());
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
    public Set<TenantRepository> getAll() {
        return null;
    }



}
