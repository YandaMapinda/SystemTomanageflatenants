package property.tenant.manegement.service.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;
import property.tenant.manegement.repository.person.impl.TenantRepositoryImpl;

import java.util.Set;

public class TenantServiceImplTest {

    private TenantRepositoryImpl repository;
    private Tenant tenant;

    private Tenant getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp(){
        this.repository = TenantRepositoryImpl.getInstance();
        this.tenant = TenantFactory.getTenant("Ziyanda");
    }

    @Test
    public void getAll() {
        Set<Tenant> tenantSet =this.repository.getAll();
        System.out.println("getAll = "+tenantSet);
    }

    @Test
    public void create() {
        Tenant tenant = this.repository.create(this.tenant);
        System.out.println("Create" +tenant);
        Assert.assertNotNull(tenant);
        Assert.assertSame(tenant,this.tenant);
    }

    @Test
    public void update() {
        String newTenant = "Zizo";
        boolean employed = false;
        Tenant updates = new Tenant.Builder().name(newTenant).build();
        System.out.println("Updated" +updates);
        this.repository.update(updates);
        Assert.assertSame(employed,updates.isEmployed());
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
        Assert.assertNotEquals(read, tenant.isEmployed());
    }
}