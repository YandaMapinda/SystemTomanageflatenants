package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Log_Rentals;
import property.tenant.manegement.factory.property.Log_RentalsFactory;

public class Log_RentalsFactoryTest {
    @Test
    public void testLog_Rentals(){
        String elec_no="9877654123456";
        Log_Rentals f = Log_RentalsFactory.getLog_Rentals(elec_no);
        System.out.println(f);
        Assert.assertNotNull(f.getElec_no());
    }
}
