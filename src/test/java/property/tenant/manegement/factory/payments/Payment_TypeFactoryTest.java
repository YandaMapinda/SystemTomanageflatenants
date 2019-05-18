package property.tenant.manegement.factory.payments;

import property.tenant.manegement.factory.payment.Payment_TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.payments.Payment_Type;

public class Payment_TypeFactoryTest {
    @Test
    public void testPayment_Type(){
        String payment_type_name ="credit";
        Payment_Type f = Payment_TypeFactory.getPayment_Type(payment_type_name);
        System.out.println(f);
        Assert.assertNotNull(f.getPayment_type_name(),f.getAccount_id());
    }
}
