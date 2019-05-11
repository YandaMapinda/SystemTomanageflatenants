package property.tenant.manegement.factory.accounting;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.property.Transaction_TypeFactory;
import property.tenant.manegement.domain.accounting.report.Transaction_Type;

public class Transaction_TypeFactoryTest {
    @Test
    public void testPropertyRooms_Type(){
        String transaction_status_name ="Archive" ;
        int transaction_status_id = 654;
        Transaction_Type f = Transaction_TypeFactory.getTransaction_Type(transaction_status_name,transaction_status_id);
        System.out.println(f);
        Assert.assertNotNull(f.getTransaction_status_name());
    }
}
