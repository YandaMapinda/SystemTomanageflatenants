package property.tenant.manegement.factory.property;

import property.tenant.manegement.factory.property.Lease_RenewalFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease_Renewal;

public class Lease_RenewalFactoryTest {

    @Test
    public void testLease_Renewal(){
        String new_lease_end_date ="21 Jan 2019";
        String new_lease_period =" 10 month";
        String renewal_date= "01 Feb 2019";
        Lease_Renewal f = Lease_RenewalFactory.getLease_Renewal(new_lease_end_date,new_lease_period,renewal_date);
        System.out.println(f);
        Assert.assertNotNull(f.getNew_lease_end_date(),f.getNew_lease_period());
    }
}
