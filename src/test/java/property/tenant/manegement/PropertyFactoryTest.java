package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.FlatFactory;

public class PropertyFactoryTest {
    @Test
    public void testFlatDetails(){
        String name ="Sout Point";
        String address ="90 plain street Cape town 8001";
        double amount = 5000.0;
        Property f = FlatFactory.getFlat(name,address,amount);
        System.out.println(f);
        Assert.assertNotNull(f.getAddress());
    }
}
