package property.tenant.manegement.service.property.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.factory.property.PropertyRooms_TypeFactory;
import property.tenant.manegement.repository.property.impl.PropertyRoomTypeRepositoryImpl;

import java.util.Set;

public class PropertyRoomTypeServiceImplTest {

    private PropertyRoomTypeRepositoryImpl repository;
    private PropertyRooms_Type lease;

    @Before
    public void setUp() throws Exception {

        this.repository = PropertyRoomTypeRepositoryImpl.getInstance();
        this.lease = PropertyRooms_TypeFactory.getPropertyRooms_Type("B block");
    }

    @Test
    public void getAll() {
        Set<PropertyRooms_Type> landlords = this.repository.getAll();
        System.out.println("In getall, all = " + landlords);
    }

    @Test
    public void create() {
        PropertyRooms_Type created = this.repository.create(this.lease);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lease);
    }

    @Test
    public void update() {
       // String date ="feb 2020";
        String name ="D block";
        PropertyRooms_Type updated = new PropertyRooms_Type.Builder().unit_type_name(name).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(name, updated.getUnit_type_name());
    }

    @Test
    public void delete() {
        this.repository.delete(lease.getUnit_type_name());
        getAll();
    }

    @Test
    public void read() {
        //PropertyRooms_Type saved = new PropertyRooms_Type();
        PropertyRooms_Type read = this.repository.read(lease.getUnit_type_name());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read, lease.getUnit_type_name());
    }
}