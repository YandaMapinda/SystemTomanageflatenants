package property.tenant.manegement.factory.accounts;

import property.tenant.manegement.domain.payments.Payment_Type;

public class Payment_TypeFactory {
    public static Payment_Type getPayment_Type(String payment_type_name, int account_id){
        return new Payment_Type.Builder().payment_type_name(payment_type_name)
                .account_id(account_id).build();
    }
}
