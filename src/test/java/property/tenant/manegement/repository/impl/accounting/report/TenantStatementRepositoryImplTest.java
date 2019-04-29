package property.tenant.manegement.repository.impl.accounting.report;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;
import property.tenant.manegement.repository.accounting.report.TenantStatementRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TenantStatementRepositoryImplTest {
    Map<String,String> values;
    TenantStatementRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = TenantStatementRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("surname","Deo");
    }


    @Test
    public void create() {
        Tenant_statement tenant = Tenant_statementFactory.getTenant_statement(1987,100.0);
        repository.create(tenant);
        assertEquals(100.0,tenant.getRent_To_Pay(),100);
    }

    @Test
    public void update() {
        Tenant_statement t = repository.read("1");
        Tenant_statement t1 =  new Tenant_statement.Builder().rent_paid(3009.0).build();
        repository.update(t1);
        Tenant_statement t2 = repository.read("1");
        assertEquals(3009.0,t2.getRent_paid(),3009.0);
    }

    @Test
    public void delete() {
        repository.delete("1");
        Tenant_statement t = repository.read("1");
        assertNull(t);
    }

    @Test
    public void read() {
        Tenant_statement t = repository.read("1");
        TestCase.assertEquals("21/feb/2019",t.getPayment_date());
    }
}