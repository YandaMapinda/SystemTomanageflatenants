package property.tenant.manegement.factory.property;

import property.tenant.manegement.factory.person.factory.LeaseFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease;

public class LeaseFactoryTest {
    @Test
    public void testLease(){
        String name = "Ziyanda";
        String date = "21/07/19";
        String flatAddress ="90 plein street Cape town 8001";
        String leaseId ="g277";
        Lease l = LeaseFactory.getLease(name,date,flatAddress,leaseId);
        System.out.println(l);
       Assert.assertEquals(l.getTenantName(),l.getDate());
    }
}
