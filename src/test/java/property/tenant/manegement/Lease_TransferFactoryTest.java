package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.property.Lease_TransferFactory;
import property.tenant.manegement.domain.property.Lease_Transfer;

public class Lease_TransferFactoryTest {
    @Test
    public void testLease_Transfer(){
        String transfer_date="21 feb 2019";
        int tenant_id= 8888;
        int from_property_lease_id=67545;
        Lease_Transfer f = Lease_TransferFactory.getLease_Transfer(transfer_date,tenant_id,from_property_lease_id);
        System.out.println(f);
        Assert.assertNotNull(f.getTransfer_date(),f.getFrom_property_lease_id());
    }
}
