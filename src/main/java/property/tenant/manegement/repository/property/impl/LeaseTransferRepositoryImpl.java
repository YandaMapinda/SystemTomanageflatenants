package property.tenant.manegement.repository.property.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.repository.property.LeaseTransferRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InLeaseTransferMemory")
public class LeaseTransferRepositoryImpl implements LeaseTransferRepository {

    private static LeaseTransferRepositoryImpl repository = null;

    private Map<String, Lease_Transfer> leaseMap;

    private LeaseTransferRepositoryImpl() {
        leaseMap = new HashMap<String, Lease_Transfer>();
    }

    public static LeaseTransferRepositoryImpl getInstance(){
        if(repository == null) repository = new LeaseTransferRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Lease_Transfer> getAll() {
        return null;
    }

    @Override
    public Lease_Transfer create(Lease_Transfer lease_transfer) {
        leaseMap.put(lease_transfer.getLease_transfer_id(),lease_transfer);
        Lease_Transfer savedR = leaseMap.get(lease_transfer.getLease_transfer_id());
        return savedR;
    }

    @Override
    public Lease_Transfer update(Lease_Transfer lease_transfer) {
        leaseMap.put(lease_transfer.getLease_transfer_id(),lease_transfer);
        Lease_Transfer savedR = leaseMap.get(lease_transfer.getLease_transfer_id());
        return savedR;
    }

    @Override
    public void delete(String s) {
        leaseMap.remove(s);
    }

    @Override
    public Lease_Transfer read(String s) {
        Lease_Transfer lease= leaseMap.get(s);
        return lease;
    }
}
