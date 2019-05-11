package property.tenant.manegement.repository.property.impl;


import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.repository.property.PropertyRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PropertyRepositoryImplTest {


    Map<String,String> values;
    PropertyRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = PropertyRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("account_name","savings");
        values.put("acountNo","1234");
    }

    @Test
    public void create() {
        Property person = PropertyFactory.getProperty("savings","1234",787.9);
        repository.create(person);
        assertEquals("1234",person.getName());
    }

    @Test
    public void update() {

        Property acc = repository.read("1234");
        Property newAcc =  new Property.Builder().address(values.get("Savings")).build();
        repository.update(newAcc);
        Property UpdateAcc= repository.read("1234");
        assertEquals(null,UpdateAcc.getProperty_id());
    }

    @Test
    public void delete() {
        repository.delete("1");
        Property acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Property acc = repository.read("1");
        assertEquals("b12",acc.getFlatNum());
    }
}