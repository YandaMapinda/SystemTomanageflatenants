package property.tenant.manegement.service.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.tenant.manegement.domain.person.Address;
import property.tenant.manegement.factory.person.factory.AddressFactory;
import property.tenant.manegement.repository.person.impl.AddressRepositoryImpl;

import java.util.Set;

public class AddressServiceImplTest {

    private AddressRepositoryImpl repository;
    private Address address;

    @Before
    public void setUp() throws Exception {

        this.repository = AddressRepositoryImpl.getInstance();
        this.address = AddressFactory.getAddress("Ny 64","Cape town");
    }

    @Test
    public void getAll() {
        Set<Address> addresses = this.repository.getAll();
        System.out.println("In getall, all = " + addresses);
    }

    @Test
    public void create() {
        Address created = this.repository.create(this.address);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.address);
    }

    @Test
    public void update() {
        String street = "Ny 64";
        String city = "Cape town";
        Address updated = new Address.Builder().city(city).street_name(street).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(city, updated.getCity());
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
        Assert.assertNotEquals(read, address.getCity());
    }
}