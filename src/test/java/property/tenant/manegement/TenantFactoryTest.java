package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;

public class TenantFactoryTest {
    @Test
    public void getTenantDetails() {

        String name = "Ziyanda";
        Tenant t = TenantFactory.getTenant(name);
        System.out.println(t);
        Assert.assertNotNull(t.getName());
    }
}
