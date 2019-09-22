package property.tenant.manegement.factory.property;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Payments;

public class Lease_PaymentsFactoryTest {
    @Test
    public void testLease(){
        String lease_payment_id = "76900";
        Lease_Payments l = Lease_PaymentsFactory.getLease_Payments(lease_payment_id);
        System.out.println(l);
        Assert.assertEquals("76900",lease_payment_id);
    }
}
