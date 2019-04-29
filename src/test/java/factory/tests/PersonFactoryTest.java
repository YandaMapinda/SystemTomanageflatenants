package factory.tests;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.factory.person.factory.Person;
import property.tenant.manegement.factory.person.factory.PersonFactory;

public class PersonFactoryTest {
    @Test
    public void testFlatDetails(){
        String name ="Sam";
        String surname ="Blake";
        String id = "1";
        Person f = PersonFactory.getPerson(name,surname,id);
        System.out.println(f);
        Assert.assertNotNull(f.getName(),f.getSurname());
    }
}
