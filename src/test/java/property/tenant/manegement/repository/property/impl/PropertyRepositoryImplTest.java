package property.tenant.manegement.repository.property.impl;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.repository.property.PropertyRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PropertyRepositoryImplTest {


    PropertyRepository repository;
    Property property;

    @Before
    public void setUp() throws Exception {
        this.repository = PropertyRepositoryImpl.getInstance();
        this.property =  PropertyFactory.getProperty("savings","1234",787.9);
    }

    @Test
    public void create() {
        Property created = this.repository.create(this.property);
        assertEquals(created,this.property);
    }

    @Test
    public void update() {
        Property updated =  new Property.Builder().flatNUm("BV657").build();
        this.repository.update(updated);
        assertEquals("BV657",updated.flatNum);
    }

    @Test
    public void delete() {
        repository.delete("1");
        Property acc= repository.read("1");
        assertNull(acc);
    }

    @Test
    public void read() {
        Property read = this.repository.read(property.flatNum);
        Assert.assertNotEquals("b12",property.getFlatNum());
    }
}