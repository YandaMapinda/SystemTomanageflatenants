package property.tenant.manegement.repository.person.impl;

import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Tenant;
import property.tenant.manegement.factory.person.factory.TenantFactory;
import property.tenant.manegement.repository.person.TenantRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class TenantRepositoryImplTest {
    Map<String,String> values;
    TenantRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = TenantRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("name","Ziya");
    }

    @Test
    public void create() {
        Tenant person = TenantFactory.getTenant("ziya");
        repository.create(person);
        assertEquals("ziya",person.getName());
    }

    @Test
    public void update() {
        Tenant person = repository.read("1");
        // String name="";
        Tenant newPerson =  new Tenant.Builder().name(values.get("name")).build();
        repository.update(newPerson);
        Tenant UpdatePerson = repository.read("1");
        assertEquals("ziya",UpdatePerson.getName());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Tenant person = repository.read("1");
        assertNull(person);
    }


    @Test
    public void read() {
        Tenant readperson = repository.read("1");
        assertEquals("b12",readperson.getId());
    }
}