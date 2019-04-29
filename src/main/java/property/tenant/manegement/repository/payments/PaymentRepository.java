package property.tenant.manegement.repository.payments;

import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.repository.IRepository;

import java.util.Set;

public interface PaymentRepository extends IRepository<Payment,String> {
    Set<PaymentRepository >getAll();
}
