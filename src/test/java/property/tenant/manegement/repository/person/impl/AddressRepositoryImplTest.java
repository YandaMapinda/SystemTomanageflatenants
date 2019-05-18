package property.tenant.manegement.repository.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.repository.person.AddressRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AddressRepositoryImplTest {
    private Address address;
    private AddressRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = AddressRepositoryImpl.getInstance();
        this.address = AddressFactory.getAddress("Ny 64","Cape town");
    }

    @Test
    public void getAll() {
        Set<Address> addresses = this.repository.getAll();
        System.out.println("getAll = " + addresses);
    }

    @Test
    public void create() {
        Address created = this.repository.create(this.address);
        System.out.println("In create, created = " + created);
        Assert.assertSame(created, this.address);
        assertEquals("Cape town",created.getCity());
    }

    @Test
    public void update() {
        Address updated =  new Address.Builder().city("Somerset").build();
        this.repository.update(updated);
        assertEquals("Somerset",updated.getCity());
    }

    @Test
    public void delete() {
        this.repository.delete(address.getCity());
        getAll();
    }

    @Test
    public void read() {
        Address read = this.repository.read(address.getCity());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,address.getCity());
    }
}