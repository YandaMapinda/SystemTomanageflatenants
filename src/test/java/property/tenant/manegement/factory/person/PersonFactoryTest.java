package property.tenant.manegement.factory.person;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.person.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;

public class PersonFactoryTest {
    @Test
    public void testFlatDetails(){
        String name ="Sam";
        String surname ="Blake";
        String id = "1";
        Person f = PersonFactory.getPerson(name,surname);
        System.out.println(f);
        Assert.assertNotNull(f.getName(),f.getSurname());
    }
}
