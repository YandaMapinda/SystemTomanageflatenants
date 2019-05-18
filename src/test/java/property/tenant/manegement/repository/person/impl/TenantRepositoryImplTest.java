package property.tenant.manegement.repository.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;
import property.tenant.manegement.repository.person.TenantRepository;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@FixMethodOrder(MethodSorters.JVM)
public class TenantRepositoryImplTest {
   private Tenant tenant;
    private TenantRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = TenantRepositoryImpl.getInstance();
        this.tenant = TenantFactory.getTenant("ziya");
    }

    @Test
    public void create() {
        Tenant created = this.repository.create(this.tenant);
        assertNotNull(created.getTenantId());
    }

    @Test
    public void update() {
        Tenant updated =  new Tenant.Builder().tenantId("44444").build();
        this.repository.update(updated);
        assertEquals("44444",updated.getTenantId());
    }

    @Test
    public void delete() {
        this.repository.delete(tenant.getTenantId());
        getAll();
    }

    @Test
    public void read() {
        Tenant read = this.repository.read(tenant.getTenantId());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,tenant.getTenantId());
    }
    @Test
    public void getAll() {
        Set<Tenant> tenantSet = this.repository.getAll();
        System.out.println("getAll = " + tenantSet);
    }
}