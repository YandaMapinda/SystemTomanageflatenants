package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.factory.property.Property_TypesFactory;
import property.tenant.manegement.repository.property.impl.PropertTypeRepositoryImpl;

import java.util.Set;

public class PropertyTypeServiceImplTest {

    private PropertTypeRepositoryImpl repository;
    private Property_Types lease;

    @Before
    public void setUp() throws Exception {

        this.repository = PropertTypeRepositoryImpl.getInstance();
        this.lease = Property_TypesFactory.getProperty_Types("Apartment");
    }

    @Test
    public void getAll() {
        Set<Property_Types> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        Property_Types created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
       // String date ="feb 2020";
        String name ="bachelor flat";
        Property_Types updated = new Property_Types.Builder().property_type_name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getProperty_type_name());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getProperty_type_name());
        getAll();
    }

    @Test
    public void read() {
        Property_Types saved = new Property_Types();
        Property_Types read = this.repository.read(saved.getProperty_type_name());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved.getProperty_type_name());
    }
}