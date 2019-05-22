package property.tenant.manegement.repository.property.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.repository.property.LeaseRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InLeaseMemory")
public class LeaseRepositoryImpl implements LeaseRepository {
    private static LeaseRepositoryImpl repository = null;

    private Map<String, Lease> leaseMap;

    private LeaseRepositoryImpl() {
        leaseMap = new HashMap<String, Lease>();
    }

    public static LeaseRepositoryImpl getInstance(){
        if(repository == null) repository = new LeaseRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Lease> getAll() {
        return null;
    }

    @Override
    public Lease create(Lease lease) {
        leaseMap.put(lease.getLeaseId(),lease);
        Lease savedR = leaseMap.get(lease.getLeaseId());
        return savedR;
    }

    @Override
    public Lease update(Lease lease) {
        leaseMap.put(lease.getLeaseId(),lease);
        Lease savedR = leaseMap.get(lease.getLeaseId());
        return savedR;
    }

    @Override
    public void delete(String s) {
    leaseMap.remove(s);
    }

    @Override
    public Lease read(String s) {
        Lease lease= leaseMap.get(s);
        return lease;
    }
}
