package property.tenant.manegement.factory.person;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.domain.person.Address;

public class AddressFactoryTest {
    @Test
    public void testContactDetails(){
        String street_name = "Plain street";
        String city ="Cape town";
        Address f = AddressFactory.getAddress(street_name,city);
        System.out.println(f);
        Assert.assertNotNull(f.getStreet_name(),f.getCity());
    }
}
