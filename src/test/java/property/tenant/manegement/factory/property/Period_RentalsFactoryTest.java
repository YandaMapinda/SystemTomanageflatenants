package property.tenant.manegement.factory.property;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Period_Rentals;

public class Period_RentalsFactoryTest {
    @Test
    public void testPeriod_Rentals(){
        double repair_amount= 566.0;
        int period_id = 776;
        double service_fees =180.9;
        Period_Rentals f = Period_RentalsFactory.getPeriod_Rentals(repair_amount,period_id);
        System.out.println(f);
        Assert.assertNotNull(f.getService_fees());
    }
}
