package property.tenant.manegement.service.accounts.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;
import property.tenant.manegement.repository.accounting.report.impl.TenantStatementRepositoryImpl;

import java.util.Set;
@FixMethodOrder(MethodSorters.JVM)
public class TenantStatementServiceImplTest {

    private TenantStatementRepositoryImpl repository;
    private Tenant_statement invoice;

    private Tenant_statement getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TenantStatementRepositoryImpl.getInstance();
        this.invoice = Tenant_statementFactory.getTenant_statement(5760.9,100.3);
    }

    @Test
    public void getAll() {
        Set<Tenant_statement> invoices = this.repository.getAll();
        System.out.println("In getall, all = " + invoices);
    }

    @Test
    public void create() {
        Tenant_statement created = this.repository.create(this.invoice);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.invoice);
    }

    @Test
    public void update() {
       // double paid = 1235.0;
       // double balance = 120.9;
        Tenant_statement updated = new Tenant_statement.Builder().rent_paid(100).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertEquals(100.0, updated.getRent_paid(),788);
    }

    @Test
    public void delete() {
        this.repository.delete(invoice.getTenant_name());
        getAll();
    }

    @Test
    public void read() {
        Tenant_statement read = this.repository.read(invoice.getTenant_name());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, invoice.getTenant_name());
    }
}