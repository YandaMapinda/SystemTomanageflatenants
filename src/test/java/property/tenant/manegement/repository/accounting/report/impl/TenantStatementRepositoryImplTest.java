package property.tenant.manegement.repository.accounting.report.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.accounting.report.Tenant_statement;
import property.tenant.manegement.factory.accounts.Tenant_statementFactory;
import property.tenant.manegement.repository.accounting.report.TenantStatementRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TenantStatementRepositoryImplTest {
    private Tenant_statement tenantStatement;
    TenantStatementRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = TenantStatementRepositoryImpl.getInstance();
        this.tenantStatement = Tenant_statementFactory.getTenant_statement(1987,100.0);
    }
    @Test
    public void getAll() {
        Set<Tenant_statement> tenantStatementSet = this.repository.getAll();
        System.out.println("getAll = " + tenantStatementSet);
    }

    @Test
    public void create() {
        Tenant_statement created = this.repository.create(this.tenantStatement);
        System.out.println("In create, created = " + created);
        Assert.assertSame(created, this.tenantStatement);
        assertEquals(100.0,tenantStatement.getRent_To_Pay(),100);
    }

    @Test
    public void update() {
        Tenant_statement updated =  new Tenant_statement.Builder().rent_paid(3009.0).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        assertEquals(3009.0,updated.getRent_paid(),3009.0);
    }

    @Test
    public void delete() {
        repository.delete("1");
        Tenant_statement t = repository.read("1");
        assertNull(t);
    }

    @Test
    public void read() {
        Tenant_statement read = this.repository.read(tenantStatement.getPayment_date());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,tenantStatement.getPayment_date());
    }
}