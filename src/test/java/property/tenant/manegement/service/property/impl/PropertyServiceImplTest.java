package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.factory.property.PropertyFactory;
import property.tenant.manegement.repository.property.impl.PropertyRepositoryImpl;

import java.util.Set;

public class PropertyServiceImplTest {

    private PropertyRepositoryImpl repository;
    private Property lease;

    @Before
    public void setUp() throws Exception {

        this.repository = PropertyRepositoryImpl.getInstance();
        this.lease = PropertyFactory.getProperty("Ny 76 gugs","Ziyanda");
    }

    @Test
    public void getAll() {
        Set<Property> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Property created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
        String address ="Langa";
       // String name ="Zizo";
        Property updated = new Property.Builder().address(address).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(address, updated.getAddress());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getAddress());
        getAll();
    }

    @Test
    public void read() {
       // Property saved = new Property();
        Property read = this.repository.read(lease.getAddress());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease.getAddress());
    }
}