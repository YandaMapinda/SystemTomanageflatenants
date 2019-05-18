package property.tenant.manegement.repository.person.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import property.tenant.manegement.domain.person.Landlord;
import property.tenant.manegement.factory.person.factory.LandlordFactory;
import property.tenant.manegement.repository.person.LandlordRepository;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.JVM)
public class LandlordRepositoryImplTest {
    private Landlord landlord;
    private LandlordRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = LandlordRepositoryImpl.getRepository();
        this.landlord = LandlordFactory.getLandLord("zee","kala","b@mail.com","0754321345");

    }

    @Test
    public void create() {
        Landlord created = this.repository.create(this.landlord);
        System.out.println("In create, created = " + created);
        assertEquals(created,this.landlord);
    }
    @Test
    public void update() {
        Landlord updated =  new Landlord.Builder().landlordId("67y").build();
        this.repository.update(updated);
        assertEquals("67y",updated.getLandlordId());
    }

    @Test
    public void delete() {
        this.repository.delete(landlord.getLandlordId());
        getAll();
    }

    @Test
    public void read() {
        Landlord read = this.repository.read(landlord.getLandlordId());
        System.out.println("In read, read = "+ read);
        Assert.assertNotEquals(read,landlord.getLandlordId());
    }
    @Test
    public void getAll() {
        Set<Landlord> landlords = this.repository.getAll();
        System.out.println("getAll = " + landlords);
    }
}