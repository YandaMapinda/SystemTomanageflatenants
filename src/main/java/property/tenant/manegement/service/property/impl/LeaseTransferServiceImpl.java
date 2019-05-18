package property.tenant.manegement.service.property.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.property.Lease_Transfer;
import property.tenant.manegement.repository.property.impl.LeaseTransferRepositoryImpl;
import property.tenant.manegement.repository.property.LeaseTransferRepository;
import property.tenant.manegement.service.property.LeaseTransferService;

import java.util.Set;
@Service
public class LeaseTransferServiceImpl implements LeaseTransferService {

    private static LeaseTransferServiceImpl service = null;
    private LeaseTransferRepository repository;

    private LeaseTransferServiceImpl() {
        this.repository = LeaseTransferRepositoryImpl.getInstance();
    }

    public static LeaseTransferServiceImpl getService(){
        if (service == null) service = new LeaseTransferServiceImpl();
        return service;
    }

    @Override
    public Set<Lease_Transfer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lease_Transfer create(Lease_Transfer lease_transfer) {
        return this.repository.create(lease_transfer);
    }

    @Override
    public Lease_Transfer update(Lease_Transfer lease_transfer) {
        return this.repository.update(lease_transfer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lease_Transfer read(String s) {
        return this.repository.read(s);
    }
}
