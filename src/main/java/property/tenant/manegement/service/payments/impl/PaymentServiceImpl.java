package property.tenant.manegement.service.payments.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.repository.payments.PaymentRepository;
import property.tenant.manegement.repository.payments.impl.PaymentRepositoryImpl;
import property.tenant.manegement.service.payments.PaymentService;

import java.util.Set;

@Service("ServicePaymentImpl")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    @Qualifier("InPaymentMemory")
    private static PaymentServiceImpl service = null;
    private PaymentRepository repository;

    private PaymentServiceImpl() {
        this.repository = PaymentRepositoryImpl.getInstance();
    }

    public static PaymentServiceImpl getService(){
        if (service == null) service = new PaymentServiceImpl();
        return service;
    }

    @Override
    public Set<Payment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.create(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.update(payment);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Payment read(String s) {
        return this.repository.read(s);
    }
}
