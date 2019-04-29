package factory.tests;

import property.tenant.manegement.factory.person.factory.TenantFactory;
import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.person.Tenant;

public class TenantFactoryTest {
    @Test
    public void getTenantDetails() {

        String name = "Ziyanda";
        Tenant t = TenantFactory.getTenant(name);
        System.out.println(t);
        Assert.assertNotNull(t.getName());
    }
}
