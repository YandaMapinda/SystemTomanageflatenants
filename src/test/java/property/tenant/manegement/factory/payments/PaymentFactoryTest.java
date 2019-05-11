package property.tenant.manegement.factory.payments;

import property.tenant.manegement.factory.accounts.PaymentFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.payments.Payment;

public class PaymentFactoryTest {

    @Test
    public void testPayment_Type(){
        String account_type_name ="credit";
        String payment_date="07 march 2019";
        Payment f = PaymentFactory.getPayment(account_type_name,payment_date);
        System.out.println(f);
        Assert.assertNotNull(f.getAccount_type_name(),f.getPayment_date());
    }
}
