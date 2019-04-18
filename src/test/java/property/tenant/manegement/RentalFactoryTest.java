package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.person.factory.RentalFactory;
import property.tenant.manegement.domain.property.Rental;

public class RentalFactoryTest {

    @Test
    public void getRentalTest() {

        String term = "no term";
        double rate= 0.0;
        Rental r = RentalFactory.getRental(term,rate);
        System.out.println(r);
        Assert.assertNotNull(r.getTerm(),r.getRate());
    }
}
