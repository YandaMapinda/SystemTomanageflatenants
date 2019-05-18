package property.tenant.manegement.factory.payment;

import property.tenant.manegement.domain.payments.Payment;
import property.tenant.manegement.util.Misc;

public class PaymentFactory {
    public static Payment getPayment(String account_type_name, String payment_date){
        return new Payment.Builder().payment_type_id(Misc.generateId()).payment_date(payment_date)
                .account_type_name(account_type_name).build();
    }
}
