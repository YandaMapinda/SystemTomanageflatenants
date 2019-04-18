package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.factory.property.Property_TypesFactory;

public class Property_TypesFactoryTest {
    @Test
    public void testProperty_Types(){
        String property_type_name="NMJ Apartments";
        Property_Types f = Property_TypesFactory.getProperty_Types(property_type_name);
        System.out.println(f);
        Assert.assertNotNull(f.getProperty_type_name());
    }
}
