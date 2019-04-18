package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.payments.Payment;

public class PaymentFactory {
    public static Payment getPayment(String account_type_name, String payment_date){
        return new Payment.Builder().payment_date(payment_date)
                .account_type_name(account_type_name).build();
    }
}
