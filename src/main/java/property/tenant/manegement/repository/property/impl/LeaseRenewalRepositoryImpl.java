package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.Lease_Renewal;
import property.tenant.manegement.repository.property.LeaseRenewalRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeaseRenewalRepositoryImpl implements LeaseRenewalRepository {

    private static LeaseRenewalRepositoryImpl repository = null;

    private Map<String, Lease_Renewal> leaseMap;

    private LeaseRenewalRepositoryImpl() {
        leaseMap = new HashMap<String, Lease_Renewal>();
    }

    public static LeaseRenewalRepositoryImpl getInstance(){
        if(repository == null) repository = new LeaseRenewalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Lease_Renewal> getAll() {
        return null;
    }

    @Override
    public Lease_Renewal create(Lease_Renewal lease_renewal) {
        leaseMap.put(lease_renewal.getLeaseId(),lease_renewal);
        Lease_Renewal savedR = leaseMap.get(lease_renewal.getLeaseId());
        return savedR;
    }

    @Override
    public Lease_Renewal update(Lease_Renewal lease_renewal) {
        leaseMap.put(lease_renewal.getLeaseId(),lease_renewal);
        Lease_Renewal savedR = leaseMap.get(lease_renewal.getLeaseId());
        return savedR;
    }

    @Override
    public void delete(String s) {
    leaseMap.remove(s);
    }

    @Override
    public Lease_Renewal read(String s) {
        Lease_Renewal lease= leaseMap.get(s);
        return lease;
    }
}
