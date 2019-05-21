package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Payments;
import property.tenant.manegement.factory.person.factory.Lease_PaymentsFactory;

public class Lease_PaymentsFactoryTest {
    @Test
    public void testLease(){
        int lease_payment_id = 2;
        Lease_Payments l = Lease_PaymentsFactory.getLease_Payments(lease_payment_id);
        System.out.println(l);
        Assert.assertEquals(2,lease_payment_id);
    }
}
