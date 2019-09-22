package property.tenant.manegement.service.property.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.repository.property.impl.LeasePaymentRepositoryImpl;
import property.tenant.manegement.repository.property.LeasePaymentRepository;
import property.tenant.manegement.service.property.LeasePaymentService;

import java.util.Set;
@Service("ServiceLeasePaymentImpl")
public class LeasePaymentServiceImpl implements LeasePaymentService {
    @Autowired
    @Qualifier("InLeasePaymentMemory")
    private static LeasePaymentServiceImpl service = null;
    private LeasePaymentRepository repository;

    private LeasePaymentServiceImpl() {
        this.repository = LeasePaymentRepositoryImpl.getInstance();
    }

    public static LeasePaymentServiceImpl getService(){
        if (service == null) service = new LeasePaymentServiceImpl();
        return service;
    }

    @Override
    public Set<Lease_Payments> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Lease_Payments create(Lease_Payments lease_payments) {
        return this.repository.create(lease_payments);
    }

    @Override
    public Lease_Payments update(Lease_Payments lease_payments) {
        return this.repository.update(lease_payments);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lease_Payments read(String s) {
        return this.repository.read(s);
    }
}
