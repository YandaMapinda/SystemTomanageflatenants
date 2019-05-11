package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.repository.property.impl.LeaseRepositoryImpl;
import property.tenant.manegement.repository.property.LeaseRepository;
import property.tenant.manegement.service.property.LeaseService;

import java.util.Set;

public class LeaseServiceImpl implements LeaseService {

    private static LeaseServiceImpl service = null;
    private LeaseRepository repository;

    private LeaseServiceImpl() {
        this.repository = LeaseRepositoryImpl.getInstance();
    }

    public static LeaseServiceImpl getService(){
        if (service == null) service = new LeaseServiceImpl();
        return service;
    }

    @Override
    public Set<Lease> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lease create(Lease lease) {
        return this.repository.create(lease);
    }

    @Override
    public Lease update(Lease lease) {
        return this.repository.update(lease);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lease read(String s) {
        return this.repository.read(s);
    }
}
