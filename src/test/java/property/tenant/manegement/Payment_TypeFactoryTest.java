package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.accounts.Payment_TypeFactory;
import property.tenant.manegement.domain.payments.Payment_Type;

public class Payment_TypeFactoryTest {
    @Test
    public void testPayment_Type(){
        String payment_type_name ="credit";
        int account_id=545;
        Payment_Type f = Payment_TypeFactory.getPayment_Type(payment_type_name,account_id);
        System.out.println(f);
        Assert.assertNotNull(f.getPayment_type_name(),f.getAccount_id());
    }
}
