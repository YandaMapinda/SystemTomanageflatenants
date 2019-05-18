package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.repository.property.LeasePaymentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeasePaymentRepositoryImpl implements LeasePaymentRepository {
    private static LeasePaymentRepositoryImpl repository = null;

    private Map<String, Lease_Payments> leaseMap;

    private LeasePaymentRepositoryImpl() {
        leaseMap = new HashMap<String, Lease_Payments>();
    }

    public static LeasePaymentRepositoryImpl getInstance(){
        if(repository == null) repository = new LeasePaymentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Lease_Payments> getAll() {
        return null;
    }

    @Override
    public Lease_Payments create(Lease_Payments lease_payments) {
        leaseMap.put(lease_payments.getLease_payment_id(),lease_payments);
        Lease_Payments savedR = leaseMap.get(lease_payments.getLease_payment_id());
        return savedR;
    }

    @Override
    public Lease_Payments update(Lease_Payments lease_payments) {
        leaseMap.put(lease_payments.getLease_payment_id(),lease_payments);
        Lease_Payments savedR = leaseMap.get(lease_payments.getLease_payment_id());
        return savedR;
    }

    @Override
    public void delete(String s) {
        leaseMap.remove(s);
    }

    @Override
    public Lease_Payments read(String s) {
        Lease_Payments lease= leaseMap.get(s);
        return lease;
    }
}
