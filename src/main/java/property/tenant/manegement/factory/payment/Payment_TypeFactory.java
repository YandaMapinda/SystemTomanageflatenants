package property.tenant.manegement.factory.payment;

import property.tenant.manegement.domain.payments.Payment_Type;
import property.tenant.manegement.util.Misc;

public class Payment_TypeFactory {
    public static Payment_Type getPayment_Type(String payment_type_name){
        return new Payment_Type.Builder().payment_type_name(payment_type_name)
               .build();
    }
}
