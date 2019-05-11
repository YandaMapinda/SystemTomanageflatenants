package property.tenant.manegement.repository.property.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Lease;
import property.tenant.manegement.factory.person.factory.LeaseFactory;
import property.tenant.manegement.repository.property.LeaseRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LeaseRepositoryImplTest {


    Map<String,String> values;
    LeaseRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = LeaseRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        Lease l = LeaseFactory.getLease("savings", "1234","ny 76","b23");
        repository.create(l);
        assertEquals(null,l.getLeaseId());
    }

    @Test
    public void update() {

        Lease l = repository.read("1234");
        Lease l2=  new Lease.Builder().tenantName(values.get("Savings"))
                .date(values.get("1234")).build();
        repository.update(l2);
        Lease l3= repository.read("1234");
        assertEquals("1234",l3.getLeaseId());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Lease l= repository.read("1");
        assertNull(l);
    }

    @Test
    public void read() {
        Lease l = repository.read("1");
        assertEquals("b12",l.getLeaseId());
    }
}