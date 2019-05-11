package property.tenant.manegement.service.payments;

import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.service.IService;

import java.util.Set;

public interface PaymentService extends IService <Payment,String> {
    Set<Payment> getAll();
}
