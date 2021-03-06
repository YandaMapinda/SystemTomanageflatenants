package property.tenant.manegement.repository.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.factory.property.LeaseFactory;
import property.tenant.manegement.repository.property.LeaseRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeaseRepositoryImplTest {

@Autowired
    private LeaseRepository repository;
    private Lease lease;

    @Before
    public void setUp() throws Exception {
        this.repository = LeaseRepositoryImpl.getInstance();
        this.lease = LeaseFactory.getLease("savings", "23 May 2019","ny 76");
    }

    @Test
    public void create() {
        Lease created = repository.create(this.lease);
        assertEquals(null,created.getLeaseId());
    }

    @Test
    public void update() {
        String name = "h656";
        Lease updated=  new Lease.Builder().tenantName(name).build();
        Lease lease1= this.repository.update(updated);
        Assert.assertSame(lease1,updated);
    }

    @Test
    public void delete() {

        this.repository.delete(lease.getLeaseId());
        getAll();
    }

    @Test
    public void read() {
        Lease read = this.repository.read(lease.getLeaseId());
        System.out.println("In read, read = "+ read);
        Assert.assertEquals(read,lease.getLeaseId());
    }
    @Test
    public void getAll() {
        Set<Lease> leaseSet = this.repository.getAll();
        System.out.println("getAll = " + leaseSet);
    }
}