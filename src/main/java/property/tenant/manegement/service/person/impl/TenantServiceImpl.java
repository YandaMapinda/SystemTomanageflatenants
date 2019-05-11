package property.tenant.manegement.service.person.impl;

import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.repository.person.impl.TenantRepositoryImpl;
import property.tenant.manegement.repository.person.TenantRepository;
import property.tenant.manegement.service.person.TenantService;

import java.util.Set;

public class TenantServiceImpl implements TenantService {
    private static TenantServiceImpl service = null;
    private TenantRepository repository;

    private TenantServiceImpl() {
        this.repository = TenantRepositoryImpl.getInstance();
    }

    public static TenantServiceImpl getService(){
        if (service == null) service = new TenantServiceImpl();
        return service;
    }

    @Override
    public Set<Tenant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Tenant create(Tenant tenant) {
        return this.repository.create(tenant);
    }

    @Override
    public Tenant update(Tenant tenant) {
        return this.repository.update(tenant);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Tenant read(String s) {
        return this.repository.read(s);
    }
}
