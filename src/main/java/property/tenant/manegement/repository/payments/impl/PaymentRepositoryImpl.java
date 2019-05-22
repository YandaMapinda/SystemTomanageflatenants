package property.tenant.manegement.repository.payments.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.repository.payments.PaymentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InPaymentMemory")
public class PaymentRepositoryImpl implements PaymentRepository {

    private static PaymentRepositoryImpl repository = null;

    private Map<String, Payment> paymentMap;

    private PaymentRepositoryImpl() {
        paymentMap = new HashMap<String, Payment>();
    }

    public static PaymentRepositoryImpl  getInstance(){
        if(repository == null) repository = new PaymentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Payment> getAll() {
        return null;
    }

    @Override
    public Payment create(Payment payment) {
        paymentMap.put(payment.getPayment_id(),payment);
        Payment savedA = paymentMap.get(payment.getPayment_id());
        return savedA;
    }

    @Override
    public Payment update(Payment payment) {
        paymentMap.put(payment.getPayment_id(),payment);
        Payment savedA = paymentMap.get(payment.getPayment_id());
        return savedA;
    }

    @Override
    public void delete(String s) {
        paymentMap.remove(s);
    }

    @Override
    public Payment read(String s) {
        Payment payment = paymentMap.get(s);
        return payment;
    }
}
