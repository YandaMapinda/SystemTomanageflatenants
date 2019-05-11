package property.tenant.manegement.factory.person;

import property.tenant.manegement.factory.person.factory.LandlordFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.person.Landlord;

public class LandlordFactoryTest {

    @Test
    public void testFlatDetails(){
        String name ="Sam";
        String surname ="Blake";
        String email = "flat.owner@gmail,co,za";
        String phoneNum ="0219872378";
        Landlord f = LandlordFactory.getLandLord(name,email,surname,phoneNum);
        System.out.println(f);
        Assert.assertNotNull(f.getName(),f.getSurname());
    }
}
