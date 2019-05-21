package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Receipts;
import property.tenant.manegement.factory.accounts.ReceiptsFactory;

public class ReceiptsFactoryTest {
    @Test
    public void testReceiptsPropertyRooms_Type(){
        String tenant_name="Ziyanda";
        double balance = 45000.78;
        Receipts f = ReceiptsFactory.getReceipts(tenant_name,balance);
        System.out.println(f);
        Assert.assertNotNull(f.getTenant_name());
    }
}
