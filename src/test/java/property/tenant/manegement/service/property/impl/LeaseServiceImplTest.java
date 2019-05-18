package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.factory.property.LeaseFactory;
import property.tenant.manegement.repository.property.impl.LeaseRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.JVM)
public class LeaseServiceImplTest {

    private LeaseRepositoryImpl repository;
    private Lease lease;

    @Before
    public void setUp() throws Exception {

        this.repository = LeaseRepositoryImpl.getInstance();
        this.lease = LeaseFactory.getLease("Ziyanda","march 2019","NY 87 gugs");
    }

    @Test
    public void getAll() {
        Set<Lease> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Lease created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        String date ="feb 2020";
       // String name ="Zizo";
        Lease updated = new Lease.Builder().date(date).tenantName("Zizo").build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertNotEquals("Zizo", updated.getTenantName());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getDate());
        getAll();
    }

    @Test
    public void read() {
        Lease read = this.repository.read(lease.getDate());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease);
    }
}