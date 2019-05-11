package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.repository.property.impl.LeaseRenewalRepositoryImpl;
import property.tenant.manegement.repository.property.LeaseRenewalRepository;
import property.tenant.manegement.service.property.LeaseRenewalService;

import java.util.Set;

public class LeaseRenewalServiceImpl implements LeaseRenewalService {

    private static LeaseRenewalServiceImpl service = null;
    private LeaseRenewalRepository repository;

    private LeaseRenewalServiceImpl() {
        this.repository = LeaseRenewalRepositoryImpl.getInstance();
    }

    public static LeaseRenewalServiceImpl getService(){
        if (service == null) service = new LeaseRenewalServiceImpl();
        return service;
    }

    @Override
    public Set<Lease_Renewal> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lease_Renewal create(Lease_Renewal lease_renewal) {
        return this.repository.create(lease_renewal);
    }

    @Override
    public Lease_Renewal update(Lease_Renewal lease_renewal) {
        return this.repository.update(lease_renewal);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lease_Renewal read(String s) {
        return this.repository.read(s);
    }
}
