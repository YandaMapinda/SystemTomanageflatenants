package property.tenant.manegement;

import org.junit.Assert;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;

public class Tenant_statementFactoryTest {
    @Test
    public void testTenant_statementPropertyRooms_Type(){
        double rent_paid =50000;
        double rent_To_Pay= 10000.9;
        Tenant_statement f = Tenant_statementFactory.getTenant_statement(rent_paid,rent_To_Pay);
        System.out.println(f);
        Assert.assertNotNull(f.getRent_paid());
    }
}
